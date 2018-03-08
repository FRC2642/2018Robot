package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LStart_LSwitch extends CommandGroup {

    public LStart_LSwitch() {
    	addSequential(new DriveByGyro(0, .8, 140, false));
    	addSequential(new TurnByGyro(90, 2));
    	//addSequential(new PlaceHolderCommand(.5));
    }
}
