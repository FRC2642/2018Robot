package org.usfirst.frc.team2642.robot.commands.lift;

import org.usfirst.frc.team2642.robot.OI;
import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCommand extends Command {

    public LiftCommand() {
        requires(Robot.lift);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.lift.moveLift(OI.auxXbox.getRawAxis(4) * .6);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.lift.stop();
    }

    protected void interrupted() {
    	Robot.lift.stop();
    }
}
