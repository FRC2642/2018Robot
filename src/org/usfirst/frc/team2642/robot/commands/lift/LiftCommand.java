package org.usfirst.frc.team2642.robot.commands.lift;

import org.usfirst.frc.team2642.robot.OI;
import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.utilities.PIDCorrection;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCommand extends Command {
	PIDCorrection liftPID = new PIDCorrection(2);
	double targetHeight;
	double currentHeight;
	double basePower = .45;
	
    public LiftCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	targetHeight = Robot.lift.liftPot.get();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (DriverStation.getInstance().isAutonomous()) {
    		currentHeight = Robot.lift.liftPot.get();
        	double correction = liftPID.calculateCorrection(targetHeight, currentHeight);
        	double power = basePower + correction;
        	if (currentHeight > targetHeight) {
        		power = (-1 * power);
        	}
        	Robot.lift.moveLift(power);
    	}
    	else {
    		Robot.lift.moveLift(OI.auxXbox.getRawAxis(5) * 1.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
