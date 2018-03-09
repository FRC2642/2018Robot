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
public class LScaleToRSwitch extends CommandGroup {

    public LScaleToRSwitch() {
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
        addSequential(new DriveByGyro(90, .8, 47, false));
        addSequential(new DriveByGyro(90, .6, 50, false));
        addSequential(new DriveByGyro(90, .8, 40, false));
        addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
        addSequential(new TurnByGyro(180, 2));
        addSequential(new DriveByGyro(180, .8, 12, false));
        addSequential(new AutoIntake(false));
    }
}
