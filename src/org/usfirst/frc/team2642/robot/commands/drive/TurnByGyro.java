package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.utilities.PIDCorrection;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class TurnByGyro extends Command {
	double targetAngle;
	double threshold;
	PIDCorrection pidCorrection = new PIDCorrection(0.008);
	boolean isStabalizing = false;
	Timer timer = new Timer();
	
    public TurnByGyro(double targetAngle, double threshold) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	this.targetAngle = targetAngle;
    	this.threshold = threshold;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentHeading = Robot.drive.getCurrentHeading();
    	double correction = pidCorrection.calculateCorrection(targetAngle, currentHeading);
    	double leftPower;
    	double rightPower;
    	if (correction > .25) {
    		correction = .25;
    	}
    	
    	if (targetAngle < currentHeading)
    	{
    		leftPower = -(.5 + correction);
    		rightPower = (.5 + correction);
    	}
    	else
    	{
    		leftPower = (.5 + correction);
    		rightPower = -(.5 + correction);
    	}
    	Robot.drive.tankMove(leftPower, rightPower);
    	
    	if (!isStabalizing){
    		if ((Robot.drive.getCurrentHeading() <= (targetAngle + threshold)) && (Robot.drive.getCurrentHeading() >= (targetAngle - threshold))) {
    			timer.start();
    			isStabalizing = true;
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (isStabalizing && (timer.get() > .3)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
