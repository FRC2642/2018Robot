package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.misc.StartAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RStart_RScale extends CommandGroup {

    public RStart_RScale() {
    	addSequential(new StartAutoCommand());
    	addSequential(new DriveByGyro(0, .9, 96, false));
    	addSequential(new DriveByGyro(0, .9, 74, false));
    	addSequential(new DriveByGyro(-42, .8, 56, false));
    	addSequential(new DriveByGyro(-10, .7, 24, false));
    	addSequential(new DriveByGyro(0, .7, 8, false));
    	addSequential(new TurnByGyro(0, 2));
    	//addSequential(new PlaceHolderCommand(.8));
    	addSequential(new DriveByGyro(0, -.8, 8, false));
    	addSequential(new DriveByGyro(0, -.8, 8, false));
    	//addSequential(new PlaceHolderCommand(1.5));
    	addSequential(new TurnByGyro(-161, 2));
    	addSequential(new DriveByGyro(-163, .8, 18, false));
    }
}
