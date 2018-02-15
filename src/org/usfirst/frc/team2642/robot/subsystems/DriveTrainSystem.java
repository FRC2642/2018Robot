package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.ArcadeDriveCommand;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrainSystem extends Subsystem {
	//Motor controllers
	public Victor leftDrive = new Victor(RobotMap.leftDriveMotorPort);
	public Victor rightDrive = new Victor(RobotMap.rightDriveMotorPort);
	
	//Sensors
	public AHRS gyro = new AHRS(Port.kUSB1);
	public Encoder leftEncoder = new Encoder(RobotMap.leftEncoderChannelA, RobotMap.leftEncoderChannelB, false, EncodingType.k4X);
	public Encoder rightEncoder = new Encoder(RobotMap.rightEncoderChannelA, RobotMap.rightEncoderChannelB, false, EncodingType.k4X);

	//DifferentialDrive
	DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDriveCommand());
    }
    
    public void move(double moveValue, double rotateValue) {
    	drive.arcadeDrive(moveValue, rotateValue);
    }
    
    public void tankMove(double leftMoveValue, double rightMoveValue) {
    	drive.tankDrive(leftMoveValue, rightMoveValue);
    }
    
    public void stop() {
    	drive.arcadeDrive(0.0, 0.0);
    }
    
    public void resetEncoder() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public int getPulsesLeft() {
    	return Math.abs(leftEncoder.get());
    }
    
    public int getPulsesRight() {
    	return Math.abs(rightEncoder.get());
    }
    
    public double getDistanceLeft() {
    	return (getPulsesLeft() / RobotMap.PULSES_PER_INCH);
    }
    
    public double getDistanceRight() {
    	return (getPulsesRight() / RobotMap.PULSES_PER_INCH);
    }
    
    public double getAverageDistance() {
    	return ((getPulsesLeft() + getPulsesRight()) / ( 2 * RobotMap.PULSES_PER_INCH));
    }
    
    public double getCurrentHeading() {
    	return gyro.getAngle();
    }
}

