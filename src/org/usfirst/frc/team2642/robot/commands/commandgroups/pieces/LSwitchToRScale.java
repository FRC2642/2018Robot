package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByVector;
import org.usfirst.frc.team2642.robot.commands.drive.ReturnByVector;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.intake.AutoIntake;
import org.usfirst.frc.team2642.robot.commands.lift.AutoLiftCommand;
import org.usfirst.frc.team2642.robot.commands.misc.FindCubeCommand;
import org.usfirst.frc.team2642.robot.commands.tilt.AutoTiltIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LSwitchToRScale extends CommandGroup {

    public LSwitchToRScale() {
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, .8, 55, false));
    	addParallel(new AutoLiftCommand(RobotMap.cubeHeight));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new TurnByGyro(137, 2));
    	addSequential(new FindCubeCommand(.5, true));
    	addSequential(new DriveByVector(.5, 24));
    	addParallel(new AutoIntake(true));
    	addSequential(new ReturnByVector(-.5));
    	addSequential(new TurnByGyro(90, 2));
    	addSequential(new DriveByGyro(90, .8, 82, false));
    	addSequential(new DriveByGyro(90, .6, 48, false));
    	addSequential(new DriveByGyro(90, .8, 42, false));
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, .7, 36, false));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new AutoIntake(false));
    }
}
