package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;


public class DegreesTurnDrive extends PIDCommand {

	private double degrees;
	
    public DegreesTurnDrive(double degrees) {
    	super(RobotMap.driveTurnP, RobotMap.driveTurnI, RobotMap.driveTurnD);
    	requires(Robot.drive);
    	this.degrees = degrees;
    	setTimeout(Math.abs(degrees / 360.0) * 3.0);
    }
 
    protected void initialize() {
    	Robot.drive.resetBothEncoders();
    	setSetpoint(Robot.drive.setDegrees(degrees));
    }

    protected void execute() {
    	//System.out.println(getSetpoint() + " " + getPosition());
    }

    protected boolean isFinished() {
        return Math.abs(getSetpoint() - getPosition()) < RobotMap.driveTurnOffset || isTimedOut();
    }

    protected void end() {
    	Robot.drive.PidDisable();
    }

    protected void interrupted() {
    	Robot.drive.PidDisable();
    }

	@Override
	protected double returnPIDInput() {
		return (Robot.drive.rightEncoderInches() - Robot.drive.leftEncoderInches()) / 2.0;	//Returns the average distance of both encoders
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.drive.driveTurn(output);
	}
}
