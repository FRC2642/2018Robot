package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByVector;
import org.usfirst.frc.team2642.robot.commands.misc.FindCubeCommand;
import org.usfirst.frc.team2642.robot.commands.drive.ReturnByVector;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.misc.WaitCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VectorExample extends CommandGroup {

    public VectorExample() {
    	/*addSequential(new DriveByGyro(0, -.8, 5, false));
    	addSequential(new DriveByGyro(0, -.8, 5, false));
    	addSequential(new PlaceHolderCommand(1.5));
    	addSequential(new TurnByGyro(161, 2));
    	addSequential(new FindCubeCommand(.8, true));
    	addSequential(new DriveByVector(.7, 24));
    	addSequential(new ReturnByVector(-.7));
    	addSequential(new PlaceHolderCommand(2));
    	addSequential(new FindCubeCommand(.8, true));
    	addSequential(new DriveByVector(.7, 24));
    	
        addSequential(new ReturnByVector(-.7));
        addSequential(new TurnByGyro(0, 2));
        addSequential(new DriveByGyro(0, .8, 5, false));
    	addSequential(new DriveByGyro(0, .8, 5, false));*/
    	
    	addSequential(new TurnByGyro(180, 2));
    	addSequential(new WaitCommand(5));
    	
    	addSequential(new FindCubeCommand(.8, true));
    	addSequential(new WaitCommand(5));
    	
    	addSequential(new DriveByVector(.5, 24));
    	addSequential(new WaitCommand(5));
    	
    	addSequential(new ReturnByVector(-.5));
    	addSequential(new WaitCommand(5));
    	
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new WaitCommand(5));
    	
    	addSequential(new TurnByGyro(-180, 2));
    	addSequential(new WaitCommand(5));
    	
    	addSequential(new FindCubeCommand(.8, true));
    	addSequential(new WaitCommand(5));
    	
    	addSequential(new DriveByVector(.5, 24));
    	addSequential(new WaitCommand(5));
    	
    	addSequential(new ReturnByVector(-.5));
    	addSequential(new WaitCommand(5));
    	
    	addSequential(new TurnByGyro(0, 2));
    }
}
