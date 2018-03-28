package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.utilities.PIDCorrection;
import org.usfirst.frc.team2642.robot.utilities.RoboRioLogger;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByGyroWithTimeOut extends Command {
	
	PIDCorrection pidCorrection = new PIDCorrection(0.008);
	double setPoint;
	double basePower;
	double targetDistance;
	double correction;
	double timeOut;
	RoboRioLogger logger;
	boolean debug;
	Timer timer = new Timer();
	
    public DriveByGyroWithTimeOut(double setPoint, double basePower, double targetDistance, boolean debug, double timeOut) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	this.setPoint = setPoint;
    	this.basePower = basePower;
    	this.targetDistance = targetDistance;
    	this.debug = debug;
    	this.timeOut = timeOut;
    	if (debug)
    	{
    		logger = new RoboRioLogger();	
    	}
    	this.debug = debug;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.resetEncoder();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentHeading = Robot.drive.getCurrentHeading();
    	double correction = pidCorrection.calculateCorrection(setPoint, currentHeading);
    	double leftPower = basePower;
    	double rightPower = basePower;
	    	if (setPoint < currentHeading)
	    	{
	    		leftPower += correction;
	    		rightPower -= correction;
	    	}
	    	else
	    	{
	    		leftPower -= correction;
	    		rightPower += correction;
	    	}
	    if (debug)
	    {
	    	Robot.logger.log("SetPoint:" + setPoint + ",Heading:" + currentHeading + ",Err:" + (setPoint - currentHeading) + ",Correction:" + correction + ",T_Distance:" + targetDistance);
	    }
    	Robot.drive.tankMove(leftPower, rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timer.get() > timeOut) {
    		return true;
    	}
        return (Robot.drive.getAverageDistance() >= targetDistance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.brake();
    	Robot.drive.stop();
    	if (debug) 
    	{
    		logger.flush();
    		logger.close();
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.stop();
    	if (debug)
    	{
    		logger.flush();
    		logger.close();
    	}
    }
}
