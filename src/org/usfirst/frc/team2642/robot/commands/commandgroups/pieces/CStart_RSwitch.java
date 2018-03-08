package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CStart_RSwitch extends CommandGroup {

    public CStart_RSwitch() {
    	addSequential(new DriveByGyro(0, .8, 6, false));
    	addSequential(new DriveByGyro(60, .8, 132, false));
    	addSequential(new DriveByGyro(50, .8, 2, false));
    	addSequential(new DriveByGyro(40, .8, 2, false));
    	addSequential(new DriveByGyro(30, .8, 2, false));
    	addSequential(new DriveByGyro(20, .8, 2, false));
    	addSequential(new DriveByGyro(10, .8, 2, false));
    	addSequential(new DriveByGyro(0, .8, 2, false));
    	addSequential(new DriveByGyro(0, .8, 40, false));
    	addSequential(new TurnByGyro(-90, 3));
    	//addSequential(new PlaceHolderCommand(.5));
    }
}
