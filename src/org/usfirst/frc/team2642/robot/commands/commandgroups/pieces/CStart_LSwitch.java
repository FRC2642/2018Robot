package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.misc.StartAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CStart_LSwitch extends CommandGroup {

    public CStart_LSwitch() {
    	addSequential(new StartAutoCommand());
    	addSequential(new DriveByGyro(0, .8, 6, false));
    	addSequential(new DriveByGyro(-60, .8, 113, false));
    	addSequential(new DriveByGyro(-50, .8, 2, false));
    	addSequential(new DriveByGyro(-40, .8, 2, false));
    	addSequential(new DriveByGyro(-30, .8, 2, false));
    	addSequential(new DriveByGyro(-20, .8, 2, false));
    	addSequential(new DriveByGyro(-10, .8, 2, false));
    	addSequential(new DriveByGyro(0, .8, 2, false));
    	addSequential(new DriveByGyro(0, .8, 66, false));
    	addSequential(new TurnByGyro(90, 3));
    //	addSequential(new PlaceHolderCommand(.8));
    }
}
