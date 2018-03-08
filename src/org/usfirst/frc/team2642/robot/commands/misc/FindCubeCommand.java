package org.usfirst.frc.team2642.robot.commands.misc;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.utilities.PIDCorrection;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FindCubeCommand extends Command {
	double basePower;
	double leftPower;
	double rightPower;
	boolean turnRight;
	PIDCorrection pidCorrection = new PIDCorrection(0.005);
	
    public FindCubeCommand(double basePower, boolean turnRight) {
    	requires(Robot.pixy);
    	requires(Robot.drive);
    	this.basePower = basePower;
    	this.turnRight = turnRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentHeading = Robot.pixy.getCubeCenter();
    	double correction = pidCorrection.calculateCorrection(140, currentHeading);
    	if (correction > .25) {
    		correction = .25;
    	}
    	if (Robot.pixy.isCubeVisible() == true) {
	    	if (Robot.pixy.getCubeCenter() < 145) {
	    		leftPower = -(.45 + correction);
	    		rightPower = (.45 + correction);
		    	Robot.drive.tankMove(leftPower, rightPower);
	    	}
	    	else if (Robot.pixy.getCubeCenter() > 135) {
	    		leftPower = (.45 + correction);
	    		rightPower = -(.45 + correction);
		    	Robot.drive.tankMove(leftPower, rightPower);
	    	}
    	}
    	else {
    		if(turnRight) {
    			Robot.drive.tankMove(basePower, -basePower);
    		}
    		else {
    			Robot.drive.tankMove(-basePower, basePower);
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if ((Robot.pixy.getCubeCenter() > 130) && (Robot.pixy.getCubeCenter() < 150)) {
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
