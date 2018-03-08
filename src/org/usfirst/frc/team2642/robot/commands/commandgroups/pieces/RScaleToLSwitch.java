package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RScaleToLSwitch extends CommandGroup {

    public RScaleToLSwitch() {
    	addSequential(new TurnByGyro(-90, 2));
    	addSequential(new DriveByGyro(-90, .8, 47, false));
    	addSequential(new DriveByGyro(-90, .6, 50, false));
    	addSequential(new DriveByGyro(-90, .8, 53, false));
    	addSequential(new TurnByGyro(-180, 2));
    	addSequential(new DriveByGyro(-180, .8, 12, false));
    }
}
