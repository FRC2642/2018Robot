package org.usfirst.frc.team2642.robot.commands.tilt;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.utilities.PIDCorrection;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DefaultTiltCommand extends Command {
	PIDCorrection tiltPID = new PIDCorrection(3.7037);
	double targetTilt;
	double currentTilt;
	double basePower = .4;
	
    public DefaultTiltCommand() {
        requires(Robot.tilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	targetTilt = Robot.tilt.tiltPot.get();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentTilt = Robot.tilt.tiltPot.get();
    	double correction = tiltPID.calculateCorrection(targetTilt, currentTilt);
    	double power = basePower + correction;
    	if (currentTilt > targetTilt) {
    		power = (-1 * power);
    	}
    	Robot.tilt.tilt(power);
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
}
