package org.usfirst.frc.team2642.robot.commands.lift;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.utilities.PIDCorrection;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLiftCommand extends Command {
	PIDCorrection liftPID = new PIDCorrection(0.008);
	double target;
	double basePower = .7;
	double currentHeight;
    public AutoLiftCommand(double target) {
    	requires(Robot.lift);
    	this.target = target;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentHeight = Robot.lift.liftPot.get();
    	double correction = liftPID.calculateCorrection(target, currentHeight);
    	double power = basePower + correction;
    	if (currentHeight > target) {
    		power = (-power);
    	}
    	Robot.lift.moveLift(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((currentHeight <= (target + .025)) && (currentHeight >= (target + .025)));
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
