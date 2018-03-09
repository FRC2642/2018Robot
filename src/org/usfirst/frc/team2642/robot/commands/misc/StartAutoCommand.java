package org.usfirst.frc.team2642.robot.commands.misc;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.utilities.PIDCorrection;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartAutoCommand extends Command {
	Timer timer = new Timer();
	PIDCorrection tiltPID = new PIDCorrection(3.7037);
	double targetTilt = RobotMap.cubeTilt;
	double currentTilt;
	double basePower = .7;
	
    public StartAutoCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tilt);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.closeIntake();
    	currentTilt = Robot.tilt.tiltPot.get();
    	double correction = tiltPID.calculateCorrection(targetTilt, currentTilt);
    	double power = basePower + correction;
    	if (currentTilt > targetTilt) {
    		power = (-1 * power);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 return ((currentTilt < (targetTilt + .04)) && (currentTilt > (targetTilt - .04)));
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
