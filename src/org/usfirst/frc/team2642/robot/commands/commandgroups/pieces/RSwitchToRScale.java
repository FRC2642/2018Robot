package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RSwitchToRScale extends CommandGroup {

    public RSwitchToRScale() {
    	addSequential(new TurnByGyro(-5, 2));
    	addSequential(new DriveByGyro(0, .8, 55, false));
    	addSequential(new TurnByGyro(-137, 2));
    	addSequential(new DriveByGyro(-137, .8, 12, false));
    	//addSequential(new PlaceHolderCommand(.5));
    	addSequential(new TurnByGyro(-25, 2));
    	addSequential(new DriveByGyro(-25, .8, 20, false));
    	addSequential(new DriveByGyro(0, .8, 10, false));
    	addSequential(new TurnByGyro(-2, 2));
    }
}
