package org.usfirst.frc.team2642.robot.commands.misc;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WaitCommand extends Command {
	Timer timer = new Timer();
	double t = 0.0;
    public WaitCommand(double seconds) {
        this.t = seconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (timer.get() > t) {
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
