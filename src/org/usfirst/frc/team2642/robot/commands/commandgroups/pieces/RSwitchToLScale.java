package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.misc.WaitCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RSwitchToLScale extends CommandGroup {

    public RSwitchToLScale() {
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, .8, 60, false));
    	addSequential(new TurnByGyro(-137, 2));
    	addSequential(new DriveByGyro(-137, .8, 26, false));
    	addSequential(new WaitCommand(.5));
    	addSequential(new DriveByGyro(-137, -.8, 6, false));
    	addSequential(new DriveByGyro(-115, -.8, 2, false));
    	addSequential(new DriveByGyro(-100, -.8, 2, false));
    	addSequential(new TurnByGyro(-90, 2));
    	addSequential(new DriveByGyro(-90, .8, 75, false));
    	addSequential(new DriveByGyro(-90, .6, 50, false));
    	addSequential(new DriveByGyro(-90, .8, 50, false));
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, .8, 16, false));
    	addSequential(new WaitCommand(.8));
    }
}
