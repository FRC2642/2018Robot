package org.usfirst.frc.team2642.robot.commands.misc;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.utilities.PIDCorrection;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FindCubeCommand extends Command {
	double basePower;
	double leftPower;
	double rightPower;
	Timer timer = new Timer();
	boolean turnRight;
	boolean isStabalizing = false;
	PIDCorrection pidCorrection = new PIDCorrection(0.005);
	
    public FindCubeCommand(double basePower, boolean turnRight) {
    	requires(Robot.drive);
    	this.basePower = basePower;
    	this.turnRight = turnRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentHeading;
    	synchronized(Robot.pixyState) {
    		currentHeading = Robot.pixyState.getCubeCenter();
    	};
    	
    	boolean isCubeVisible;
    	synchronized(Robot.pixyState) {
    		isCubeVisible = Robot.pixyState.getIsCubeVisible();
    	};
    	double correction = pidCorrection.calculateCorrection(160, currentHeading);
    	if (correction > .25) {
    		correction = .25;
    	}
    	if (isCubeVisible) {
	    	if (currentHeading > 165) {
	    		leftPower = -(.4 + correction);
	    		rightPower = (.4 + correction);
		    	Robot.drive.tankMove(leftPower, rightPower);
	    	}
	    	else if (currentHeading < 155) {
	    		leftPower = (.4 + correction);
	    		rightPower = -(.4 + correction);
		    	Robot.drive.tankMove(leftPower, rightPower);
	    	}
    	}
    	else {
    		if(turnRight) {
    			Robot.drive.tankMove(-basePower, basePower);
    		}
    		else {
    			Robot.drive.tankMove(basePower, -basePower);
    		}
    	}
    	/*if ((Robot.pixy.getCubeCenter() > 150) && (Robot.pixy.getCubeCenter() < 170) && !isStabalizing) {
    		timer.start();
    		isStabalizing = true;
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double currentHeading;
    	synchronized(Robot.pixyState) {
    		currentHeading = Robot.pixyState.getCubeCenter();
    	};
    	
    	if ((currentHeading > 150) && (currentHeading < 170)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
