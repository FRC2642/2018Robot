package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.ArcadeDrive;
//import org.usfirst.frc.team2642.robot.commands.drive.DriveCommand;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrainSystem extends Subsystem {
	private boolean isDriveStraight = true;

	//Drive
	//RobotDrive robotdrive = new RobotDrive(RobotMap.left,
	//		RobotMap.right);
	
	public VictorSP leftDrive = new VictorSP(RobotMap.leftDriveMotorPort);
	public VictorSP rightDrive = new VictorSP(RobotMap.rightDriveMotorPort);

	//make drive system
	DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);
	
	//Encoders for drive
	Encoder lEncoder = new Encoder(RobotMap.lEncoder1, RobotMap.lEncoder2, false, Encoder.EncodingType.k4X);
	Encoder rEncoder = new Encoder(RobotMap.rEncoder1, RobotMap.rEncoder2, false, Encoder.EncodingType.k4X);

	
	 static AHRS gyro;
	 DifferentialDrive gyroDrive;
	   PIDController turnController;
	   double rotateToAngleRate;

	   
	   public void RobotDriveWithPID()
	   {
		   //fite me nerd
		  try
		  {
			  
			  gyro = new AHRS(I2C.Port.kOnboard);
			  
			  turnController = new PIDController(
					      RobotMap.turnController_kP,
						  RobotMap.turnController_kI,
						  RobotMap.turnController_kD, 
						  RobotMap.turnController_kF, 
						  gyro, (PIDOutput) this);
			  turnController.setInputRange(-180.0f,  180.0f);
			  turnController.setOutputRange(-1.0, 1.0);
			  turnController.setAbsoluteTolerance(RobotMap.turnCotrollerToleranceDegrees);
			  turnController.setContinuous(true);

		/**	
			  drive.setInvertedMotor(MotorType.kRearLeft, true);
			  drive.setInvertedMotor(MotorType.kRearRight, true);
			*/  
			  drive.setSafetyEnabled(false);
			
			 
		  }
		  catch(Exception ex)
		  {
			 //handle errors 
		  }
		  finally
		  {
			//clean up  
		  }
		  
	   }
	   
	  
	    public void pidWrite(double output) 
	    {
	        rotateToAngleRate = output;
	    }
	    public void drive(double moveValue, double rotateValue)
	    {
	    	drive.arcadeDrive(moveValue, rotateValue);
	    }
	    public void stopWithGyro()
	    {
	    	drive.arcadeDrive(0.0, 0.0);
	    }
	    public void PidEnable()
	    {
	    	turnController.enable();
	    }
	    public void PidDisable()
	    {
	    	turnController.disable();
	    }
	    public void setSetPoint(double setpoint)
	    {
	    	turnController.setSetpoint(setpoint);
	    }
	    public double getSetPoint()
	    {
	    	return turnController.getSetpoint();
	    }
	    public double getRotateToAngleRate()
	    {
	    	return rotateToAngleRate;
	    }
	    public double getAngle()
	    {
	    	return gyro.getAngle();
	    }
	    public boolean isOnTarget()
	    {
	    	return turnController.onTarget();
	    }
	    public boolean isMoving()
	    {
	    	return gyro.isMoving();
	    }
	    public boolean isConnected()
	    {
	    	return gyro.isConnected();
	    }
	    public boolean isCalibrating()
	    {
	    	return gyro.isCalibrating();
	    }
	
	    public void ResetGyro() {
	    	gyro.reset();
	    	
	    }

	//Standard driving
	public void move(double moveValue, double rotateValue){
	    drive.arcadeDrive(moveValue, rotateValue);
	    }
	
	 public void stop(){
	    	drive.stopMotor();
	    	
	    }

	public static double getGyro() {
		return gyro.getAngle() % 360.0;
	}

	public static void resetGyro() {
		gyro.reset();
	}
	
	public double getEncoderLeft(){
		System.out.println(lEncoder.getDistance());
		return lEncoder.getDistance();
	}
	
	public double getEncoderRight(){
		return rEncoder.getDistance();
	}
	
	public void resetBothEncoders(){
		lEncoder.reset();
		rEncoder.reset();
	}
	
	//Returns a given encoder value as inches
	public double encoderInches(double encoderValue){
		return encoderValue / 12.9;
	}
	
	//Returns the left encoder distance as inches
	public double leftEncoderInches(){
		return encoderInches(getEncoderLeft());
	}
	
	public double rightEncoderInches(){
		return encoderInches(getEncoderRight());
	}
	
	public double setDegrees(double degrees){
		return degrees * -0.26;
	}
	
	//Changes the autonomous driving type
	public void setIsDriveStraight(boolean state){
		isDriveStraight = state;
	}
	public double getPosition() {
		return (leftEncoderInches() * .5 + rightEncoderInches() * .5);
	}
  
	
	//Drives straight in autonomous with PID control
	public void driveStraight(double speed){
		double correction = 0.0;
		//Checks to see if the difference between the left and right is within a margin of error
		if(Math.abs(leftEncoderInches() - rightEncoderInches()) > RobotMap.driveForwardOffset){	
			//Left distance is less than right distance
			if(leftEncoderInches() < rightEncoderInches()){
				correction = -RobotMap.driveCorrection;
			}else{	//Right distance is less than left distance
				correction = RobotMap.driveCorrection;
			}
		}
		move(-speed, correction);	//Drives with the correction value
	}
	
	//Turns in autonomous with PID control
	public void driveTurn(double speed){
		double correctionL = 0.0; 
		double correctionR = 0.0;
		//Checks to see if the difference between the left and right is within a margin of error
		if(Math.abs(leftEncoderInches() + rightEncoderInches()) > RobotMap.driveForwardOffset){
			if(leftEncoderInches() > rightEncoderInches())	//Left distance is greater than right distance
				correctionR = -RobotMap.driveCorrection;
			}else{
				correctionL = -RobotMap.driveCorrection;
			}
		drive.tankDrive(-speed - correctionL, speed - correctionR);	//Drives as a tank drive to correct turning drift
	}
	
	
	//Drives off of a controller by default
    public void initDefaultCommand() {
    	setDefaultCommand(new ArcadeDrive());
    }
    
	protected double returnPIDInput() {
		if(isDriveStraight)
			return (rightEncoderInches() + leftEncoderInches()) / 2.0;	//Returns the average distance of both encoders
		else
			return (rightEncoderInches() - leftEncoderInches()) / 2.0;	//Returns the average distance of both encoders
	}

	protected void usePIDOutput(double output) {	//Changes the output based on what driving we are doing
		if(isDriveStraight)
			driveStraight(output);		
		else
			driveTurn(output);
		
	}
}
