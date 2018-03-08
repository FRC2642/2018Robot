package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LSwitchToRScale extends CommandGroup {

    public LSwitchToRScale() {
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, .8, 55, false));
    	addSequential(new TurnByGyro(137, 2));
    	addSequential(new DriveByGyro(137, .8, 14, false));
    	//addSequential(new PlaceHolderCommand(.5));
    	addSequential(new DriveByGyro(120, -.8, 5, false));
    	addSequential(new DriveByGyro(110, -.8, 5, false));
    	addSequential(new DriveByGyro(100, -.8, 5, false));
    	addSequential(new TurnByGyro(90, 2));
    	addSequential(new DriveByGyro(90, .8, 66, false));
    	addSequential(new DriveByGyro(90, .6, 48, false));
    	addSequential(new DriveByGyro(90, .8, 42, false));
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, .7, 36, false));
    	//addSequential(new PlaceHolderCommand(.8));
    }
}
