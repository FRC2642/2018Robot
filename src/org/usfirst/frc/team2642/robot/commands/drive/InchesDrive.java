package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;


public class InchesDrive extends Command {

	private double inches;
	
    public InchesDrive(double inches) {
    	requires(Robot.drive);
    	setTimeout(Math.abs(inches/12) * 0.20);
    	this.inches = inches;
    }

    protected void initialize() {
    	Robot.drive.resetBothEncoders();
    	Robot.drive.setSetPoint(inches);
    	Robot.drive.setIsDriveStraight(true);
    	Robot.drive.PidEnable();
    }

    protected void execute() {}

    protected boolean isFinished() {
        return Math.abs(Robot.drive.getSetPoint() - Robot.drive.getPosition()) < RobotMap.driveForwardOffset || isTimedOut();
        		
    }

    protected void end() {
    	Robot.drive.PidDisable();
    }

    protected void interrupted() {
    	Robot.drive.PidDisable();
    }
}
