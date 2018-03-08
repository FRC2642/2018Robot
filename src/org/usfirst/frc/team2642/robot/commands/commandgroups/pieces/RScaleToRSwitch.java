package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RScaleToRSwitch extends CommandGroup {

    public RScaleToRSwitch() {
    	addSequential(new DriveByGyro(0, -.8, 6, false));
    	addSequential(new DriveByGyro(0, -.8, 6, false));
    	//addSequential(new PlaceHolderCommand(1.5));
    	addSequential(new TurnByGyro(-170, 2));
    	addSequential(new DriveByGyro(-170, .8, 19, false));
    }
}
