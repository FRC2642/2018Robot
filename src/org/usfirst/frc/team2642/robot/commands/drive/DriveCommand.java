package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.OI;
import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

    public DriveCommand() {
    	requires(Robot.drive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	

    	//High Speed Turn
    	if(isRightTriggerPulled()) {
    		Robot.drive.move(OI.xbox.getRawAxis(1) * 1, OI.xbox.getRawAxis(0) * 1);
    		
    	//High Speed Drive
    	} else if(isLeftTriggerPulled()) {
    		Robot.drive.move(OI.xbox.getRawAxis(1) * 1, OI.xbox.getRawAxis(0) * .6);
    		
    	//Regular Drive
    	} else {
    		Robot.drive.move(OI.xbox.getRawAxis(1) * .6, OI.xbox.getRawAxis(0) * .6);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.stop();
    }
    
    public boolean isRightTriggerPulled() {
    	if(OI.xbox.getRawAxis(3) > .5) {
    		return true;
    	} else {
    		return false;
    	}
    }
    public boolean isLeftTriggerPulled() {
    	if(OI.xbox.getRawAxis(2) > .5) {
    	return true;
    } else {
    	return false;	
    	}
    }
}