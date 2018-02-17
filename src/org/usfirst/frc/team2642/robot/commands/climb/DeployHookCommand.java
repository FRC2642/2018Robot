package org.usfirst.frc.team2642.robot.commands.climb;

import org.usfirst.frc.team2642.robot.OI;
import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeployHookCommand extends Command {

    public DeployHookCommand() {
    	requires(Robot.climb);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isAButtonPressed()) {
    		Robot.climb.deployHook();
    	}
    	else if(isXButtonPressed()) {
    		Robot.climb.resetHook();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    public boolean isAButtonPressed() {
    	if(OI.auxXbox.getAButtonPressed()) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean isXButtonPressed() {
    	if(OI.auxXbox.getXButtonPressed()) {
    	return true;
    } else {
    	return false;	
    	}
    }
}
