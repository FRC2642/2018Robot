package org.usfirst.frc.team2642.robot.commands.lift;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.utilities.PIDCorrection;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLiftCommand extends Command {
	PIDCorrection liftPID = new PIDCorrection(2);
	double target;
	double basePower = .45;
	double currentHeight;
	
	public enum LiftHeight {
		CUBE(RobotMap.cubeHeight),
		SWITCH(RobotMap.switchHeight),
		SCALE(RobotMap.scaleHeight);

		@SuppressWarnings("unused")
		private double height;
		
		LiftHeight(double height) {
		this.height = height;
		}
	}
    public AutoLiftCommand(double target) {
    	requires(Robot.lift);
    	this.target = target;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.lift.enable();
    	//Robot.lift.setSetpoint(target);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentHeight = Robot.lift.liftPot.get();
    	double correction = liftPID.calculateCorrection(target, currentHeight);
    	if (correction > .5) {
    		correction = .5;
    	}
    	double power = basePower + correction;
    	if (currentHeight > target) {
    		power *= 1;
    	}
    	else {
    		power *= -1;
    	}
    	Robot.lift.moveLift(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((currentHeight <= (target + .01)) && (currentHeight >= (target - .01)));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.lift.stop();
    }
}
