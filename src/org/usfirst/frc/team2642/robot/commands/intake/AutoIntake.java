package org.usfirst.frc.team2642.robot.commands.intake;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoIntake extends Command {
	boolean intakeIn;
	boolean isInRange = false;
	boolean isDone = false;
	boolean timerStarted = false;
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
    		boolean isCubeInRange = false;
        	synchronized(Robot.sonarState) {
        		isCubeInRange = Robot.sonarState.getIsCubeInRange();
        	}
        	
    		if (isCubeInRange){
    			Robot.intake.closeIntake();
    			Robot.intake.intakeIn();
    			isInRange = true;
        	}
    		
    		if ((isInRange && (!timerStarted))){
        		timer.start();
        		timerStarted = true;
        	}
    		
    		if (timer.get() >= .7) {
        		isDone = true;
        	}
    	}
    	else {
    		//Robot.intake.releaseIntake();
    		if (Robot.lift.liftPot.get() > (RobotMap.switchHeight + .15)) {
    			Robot.intake.intakeOut(.72);
    		}
    		else {
    			Robot.intake.intakeOut();
    		}
    		
    		if ((!isInRange)){
        		timer.start();
        		isInRange = true;
        	}
    		
    		if (timer.get() >= .5) {
        		isDone = true;
        	}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (isDone);
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
}
