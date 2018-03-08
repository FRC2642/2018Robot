package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RScaleToRSwitch extends CommandGroup {

    public RScaleToRSwitch() {
    	addSequential(new TurnByGyro(-161, 2));
    	addSequential(new DriveByGyro(-163, .8, 18, false));
    	addSequential(new DriveByGyro(-163, -.8, 18, false));
    	addSequential(new TurnByGyro(-140, 2));
    	addSequential(new DriveByGyro(-140, .8, 19, false));
    }
}
