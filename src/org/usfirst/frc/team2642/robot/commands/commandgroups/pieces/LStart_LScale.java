package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LStart_LScale extends CommandGroup {

    public LStart_LScale() {
    	addSequential(new DriveByGyro(0, .9, 163, false));
    	addSequential(new DriveByGyro(34, .8, 59, false));
    	addSequential(new DriveByGyro(25, .8, 2, false));
    	addSequential(new DriveByGyro(10, .8, 2, false));
    	addSequential(new DriveByGyro(0, .8, 20, false));
    	addSequential(new TurnByGyro(0, 2));
    	//addSequential(new PlaceHolderCommand(.5));
    }
}
