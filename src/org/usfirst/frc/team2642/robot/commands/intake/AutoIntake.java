package org.usfirst.frc.team2642.robot.commands.intake;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoIntake extends Command {
	boolean intakeIn;
	boolean isInRange = false;
	Timer timer = new Timer();
    public AutoIntake(boolean intakeIn) {
    	requires(Robot.intake);
    	this.intakeIn = intakeIn;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (intakeIn) {
    		Robot.intake.closeIntake();
    		Robot.intake.intakeIn();
    		if ((Robot.sonar.getDistance() <= 12) && (!isInRange)){
        		timer.start();
        		isInRange = true;
        	}
    	}
    	else {
    		Robot.intake.openIntake();
    		Robot.intake.intakeOut();
    		if ((!isInRange)){
        		timer.start();
        		isInRange = true;
        	}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (timer.get() >= .5);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
