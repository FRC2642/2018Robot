package org.usfirst.frc.team2642.robot.commands.intake;

import org.usfirst.frc.team2642.robot.OI;
import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCommand extends Command {

    public IntakeCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isLeftTriggerPulled()) {
    		Robot.intake.closeIntake();
    		Robot.intake.intakeIn();
    	}
    	else if (isRightTriggerPulled()) {
    		Robot.intake.openIntake();
    		Robot.intake.intakeOut();
    	}
    	else {
    		Robot.intake.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.stop();
    }

    public boolean isRightTriggerPulled() {
    	if(OI.auxXbox.getRawAxis(3) > .5) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean isLeftTriggerPulled() {
    	if(OI.auxXbox.getRawAxis(2) > .5) {
    	return true;
    } else {
    	return false;	
    	}
    }
}
