package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.tilt.DefaultTiltCommand;
import org.usfirst.frc.team2642.robot.commands.tilt.TiltIntakeCommand;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class IntakeTiltSystem extends PIDSubsystem {
	
	//Motor to tilt intake arm
	VictorSP intakeTiltMotor = new VictorSP(RobotMap.intakeTiltMotorPort);
    
	public AnalogPotentiometer tiltPot = new AnalogPotentiometer(RobotMap.tiltPotPort); 
	
    public IntakeTiltSystem() {
    	//P, I, and D values
    	super(.001, 0, 0);
    	disable();
    	intakeTiltMotor.setInverted(true);
    }

    public void initDefaultCommand() {
       /* if (DriverStation.getInstance().isAutonomous()) {
        	setDefaultCommand(new DefaultTiltCommand());
        }
        else {
        	setDefaultCommand(new TiltIntakeCommand());
        }*/
    	setDefaultCommand(new TiltIntakeCommand());
    }

    protected double returnPIDInput() {
        return tiltPot.pidGet();
    }

    protected void usePIDOutput(double output) {
    	tilt(output);
    }
    
    //Tilt the intake
    public void tilt(double speed) {
    	if ((speed > 0) && (tiltPot.get() <= RobotMap.maxTilt)) {
    		intakeTiltMotor.set(speed);
    	}
    	else if ((speed < 0) && (tiltPot.get() >= RobotMap.minTilt)) {
    		intakeTiltMotor.set(speed);
    	}
    	else {
    		stop();
    	}
    }

    public void lowerTilt() {
    //	intakeTiltMotor.se
    }
    
    public void invertMotor(boolean isInverted) {
    	intakeTiltMotor.setInverted(isInverted);
    }
    
    //Off
    public void stop() {
    	intakeTiltMotor.set(0.0);
    }

}
