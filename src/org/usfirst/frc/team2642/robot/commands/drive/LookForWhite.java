package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import org.usfirst.frc.team2642.robot.TapeTargetInfo;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LookForWhite extends Command {

boolean left;
	
    public LookForWhite(boolean left) {
    	this.left = left;
    	requires(Robot.drive);
    	        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(left) {
    		Robot.drive.move(0, -RobotMap.driveSwitchCorrection*1.1);
    	}
    	else {
    		Robot.drive.move(0, RobotMap.driveSwitchCorrection*1.1);
    	}

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(TapeTargetInfo.getTapeCenterX()) < 30) || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}


