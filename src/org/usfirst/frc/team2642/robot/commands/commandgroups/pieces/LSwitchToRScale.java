package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByPixy;
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
public class LSwitchToRScale extends CommandGroup {

    public LSwitchToRScale() {
    	/*addSequential(new TurnByGyro(0, 2));
    	addParallel(new AutoLiftCommand(RobotMap.cubeHeight));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addParallel(new AutoClamp(false));
    	addSequential(new DriveByGyro(0, .9, 40, false));
    	addSequential(new TurnByGyro(137, 2));
    	addSequential(new FindCubeCommand(.5, true));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByPixy(.5));
    	addSequential(new WaitCommand(.5));
    	addSequential(new ReturnByVector(-.5));
    	addSequential(new TurnByGyro(90, 2));
    	addSequential(new DriveByGyro(90, .9, 60, false));
    	addSequential(new DriveByGyro(90, .7, 48, false));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new DriveByGyro(90, .9, 42, false));
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, .9, 10, false));
    	addSequential(new AutoIntake(false));
    	addSequential(new DriveByGyro(0, -.9, 10, false));*/
    	
    	addSequential(new TurnByGyro(0, 2));
    	addParallel(new AutoLiftCommand(RobotMap.cubeHeight));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addParallel(new AutoClamp(false));
    	addSequential(new DriveByGyro(0, .8, 60, false));
    	addSequential(new TurnByGyro(150, 2));
    	addSequential(new FindCubeCommand(.5, true));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByPixy(.5));
    	addSequential(new WaitCommand(.3));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addSequential(new ReturnByVector(-.5));
    	addSequential(new TurnByGyro(90, 2));
    	addSequential(new DriveByGyro(90, .9, 60, false));
    	addSequential(new DriveByGyro(90, .7, 48, false));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new DriveByGyro(90, .9, 80, false));
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, .9, 20, false));
    	addSequential(new TurnByGyro(-60, 2));
    	addSequential(new AutoIntake(false));
    }
}