package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByVector;
import org.usfirst.frc.team2642.robot.commands.drive.ReturnByVector;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.intake.AutoClamp;
import org.usfirst.frc.team2642.robot.commands.intake.AutoIntake;
import org.usfirst.frc.team2642.robot.commands.lift.AutoLiftCommand;
import org.usfirst.frc.team2642.robot.commands.misc.FindCubeCommand;
import org.usfirst.frc.team2642.robot.commands.misc.WaitCommand;
import org.usfirst.frc.team2642.robot.commands.tilt.AutoTiltIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LSwitchToLScale extends CommandGroup {

    public LSwitchToLScale() {
    	addSequential(new TurnByGyro(0, 2));
    	addParallel(new AutoLiftCommand(RobotMap.cubeHeight));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new DriveByGyro(0, .8, 50, false));
    	addSequential(new TurnByGyro(145, 2));
    	addSequential(new AutoClamp(false));
    	addSequential(new FindCubeCommand(.5, true));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByVector(.5));
    	addSequential(new WaitCommand(.3));
    	addSequential(new ReturnByVector(-.5));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addParallel(new AutoClamp(true));
    	addSequential(new TurnByGyro(15, 2));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new AutoLiftCommand(RobotMap.scaleHeight));
    	addSequential(new DriveByGyro(15, .8, 7, false));
    	addSequential(new DriveByGyro(0, .8, 7, false));
    	addSequential(new AutoIntake(false));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new DriveByGyro(0, -.8, 24, false));
    	addParallel(new AutoLiftCommand(RobotMap.cubeHeight));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new TurnByGyro(135, 2));
    	addSequential(new DriveByGyro(135, .8, 18, false));
    }
}
