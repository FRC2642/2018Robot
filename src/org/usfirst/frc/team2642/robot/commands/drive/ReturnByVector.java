package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.utilities.PIDCorrection;
import org.usfirst.frc.team2642.robot.utilities.VectorValues;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReturnByVector extends Command {
	PIDCorrection pidCorrection = new PIDCorrection(0.008);
	double setPoint;
	double basePower;
	double targetDistance;
	double correction;
	PIDCorrection powerPID = new PIDCorrection(0.006);
	
    public ReturnByVector(double basePower) {
    	requires(Robot.drive);
    	this.basePower = basePower;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.resetEncoder();
    	this.setPoint = VectorValues.getAngle();
    	double heading = Robot.drive.getCurrentHeading();
    	if (heading > 180) {
    		setPoint += (180 - setPoint) * 2;
    	}
    	else if (heading < -180) {
    		setPoint += (180 - setPoint) * 2;
    		setPoint += (0 - setPoint) * 2;
    	}
    	else if (heading < 0) {
    		setPoint += (0 - setPoint) * 2;
    	}
    	this.targetDistance = (VectorValues.getMagnitude() / RobotMap.PULSES_PER_INCH);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentHeading = Robot.drive.getCurrentHeading();
    	double correction = pidCorrection.calculateCorrection(setPoint, currentHeading);
    	double currentDistance = Robot.drive.getAverageDistance();
    	double powerCorrection = powerPID.calculateCorrection(targetDistance, currentDistance);
    	
    	if(powerCorrection > .25) {
    		powerCorrection = .25;
    	}
    	double leftPower = basePower - powerCorrection;
    	double rightPower = basePower - powerCorrection;
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
    	Robot.drive.tankMove(leftPower, rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Robot.drive.getAverageDistance() >= targetDistance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	VectorValues.reset();
    	Robot.drive.brake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
