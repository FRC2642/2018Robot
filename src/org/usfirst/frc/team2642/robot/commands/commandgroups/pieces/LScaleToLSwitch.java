package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LScaleToLSwitch extends CommandGroup {

    public LScaleToLSwitch() {
    	addSequential(new TurnByGyro(161, 2));
    	addSequential(new DriveByGyro(163, .8, 19, false));
    	//addSequential(new PlaceHolderCommand(1.5));
    	addSequential(new DriveByGyro(163, -.8, 19, false));
    	//addSequential(new PlaceHolderCommand(1.5));
    	addSequential(new TurnByGyro(125, 2));
    	addSequential(new DriveByGyro(125, .8, 18, false));
    }
}