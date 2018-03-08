package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LSwitchToLScale extends CommandGroup {

    public LSwitchToLScale() {
    	addSequential(new TurnByGyro(-5, 2));
    	addSequential(new DriveByGyro(0, .8, 55, false));
    	addSequential(new TurnByGyro(137, 2));
    	addSequential(new DriveByGyro(137, .8, 10, false));
    	//addSequential(new PlaceHolderCommand(.5));
    	addSequential(new TurnByGyro(15, 2));
    	addSequential(new DriveByGyro(15, .8, 16, false));
    	addSequential(new DriveByGyro(0, .8, 20, false));
    	//addSequential(new PlaceHolderCommand(.5));
    	addSequential(new DriveByGyro(0, -.8, 8, false));
    	addSequential(new DriveByGyro(0, -.8, 8, false));
    	//addSequential(new PlaceHolderCommand(1.5));
    	addSequential(new TurnByGyro(135, 2));
    	addSequential(new DriveByGyro(135, .8, 18, false));
    }
}
