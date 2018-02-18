package org.usfirst.frc.team2642.robot.commands.brake;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeployBrakeCommand extends Command {

    public DeployBrakeCommand() {
    	requires(Robot.brake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.brake.deployBrake();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.brake.brakeCylinder.get() == Value.kForward) {
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
