package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.utilities.PIDCorrection;
import org.usfirst.frc.team2642.robot.utilities.VectorValues;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByPixy extends Command {
	double encoderValue;
	double totalEncoderValue;
	double vectorComponentX;
	double vectorComponentY;
	double basePower;
	double distance;
	double leftPower;
	double rightPower;
	PIDCorrection pixyCorrection = new PIDCorrection(0.005);
	PIDCorrection sonarCorrection = new PIDCorrection(0.006);
    public DriveByPixy(double basePower) {
        /*requires(Robot.sonar);
        requires(Robot.pixy);*/
    	requires(Robot.drive);
        this.basePower = basePower;
        this.distance = RobotMap.sonarCubeDistance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentPulses;
    	double currentHeading;
    	synchronized(Robot.pixyState) {
    		currentHeading = Robot.pixyState.getCubeCenter();
    	};
    	double headingCorrection = pixyCorrection.calculateCorrection(160, currentHeading);
    	//double currentDistance = Robot.sonar.getDistance();
    	//double powerCorrection = sonarCorrection.calculateCorrection(distance, currentDistance);
    	if (headingCorrection > .25) {
    		headingCorrection = .25;
    	}
    	/*if(powerCorrection > .25) {
    		powerCorrection = .25;
    	}*/
    	
    	double power = basePower + .25;
    	if (currentHeading > 165) {
    		leftPower = (power - headingCorrection);
    		rightPower = (power + headingCorrection);
    	}
    	else if (currentHeading < 155) {
    		leftPower = (power + headingCorrection);
    		rightPower = (power - headingCorrection);
    	}
    	else {
    		leftPower = power;
    		rightPower = power;
    	}
    	Robot.drive.tankMove(leftPower, rightPower);
    	
    	currentPulses = Robot.drive.getPulsesLeft();
    	encoderValue = currentPulses - VectorValues.lastEncoderPulses;
    	VectorValues.lastEncoderPulses = currentPulses;
    	VectorValues.vectorComponentX += (Math.sin(Robot.drive.getCurrentHeading() * (Math.PI / 180 )) * encoderValue);
    	VectorValues.vectorComponentY += (Math.cos(Robot.drive.getCurrentHeading() * (Math.PI / 180 )) * encoderValue);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean isCubeInRange = false;
    	synchronized(Robot.sonarState) {
    		isCubeInRange = Robot.sonarState.getIsCubeInRange();
    	}
    	return isCubeInRange;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.brake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
