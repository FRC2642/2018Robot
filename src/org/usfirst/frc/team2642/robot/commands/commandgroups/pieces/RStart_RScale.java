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
import org.usfirst.frc.team2642.robot.commands.misc.StartAutoCommand;
import org.usfirst.frc.team2642.robot.commands.misc.WaitCommand;
import org.usfirst.frc.team2642.robot.commands.tilt.AutoTiltIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RStart_RScale extends CommandGroup {

    public RStart_RScale() {
    	/*addParallel(new AutoClamp(true));
    	addParallel(new AutoTiltIntake(.7));
    	addSequential(new DriveByGyro(0, .9, 164, false));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new DriveByGyro(-36, .8, 55, false));
    	addSequential(new DriveByGyro(-25, .8, 2, false));
    	addSequential(new DriveByGyro(-10, .8, 2, false));
    	addSequential(new DriveByGyro(0, .7, 13, false));
    	addSequential(new TurnByGyro(-5, 2));
    	addSequential(new AutoIntake(false));
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, -.8, 20, false));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new AutoLiftCommand(RobotMap.cubeHeight));*/
    	
    	addParallel(new AutoClamp(true));
    	addParallel(new AutoTiltIntake(.7));
    	addSequential(new DriveByGyro(0, .9, 100, false));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new DriveByGyro(0, .75, 68, false));
    	addSequential(new DriveByGyro(0, .6, 50, false));
    	addSequential(new TurnByGyro(-60, 2));
    	addSequential(new DriveByGyro(0, .9, 10, false));
    	addSequential(new AutoIntake(false));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addParallel(new AutoLiftCommand(RobotMap.cubeHeight));
    	addParallel(new AutoClamp(false));
     	addSequential(new TurnByGyro(-140, 2));
     	addSequential(new FindCubeCommand(.6, true));
     	addSequential(new AutoLiftCommand(RobotMap.cubeHeight));
     	addParallel(new AutoIntake(true));
     	addSequential(new DriveByPixy(.5));
     	addSequential(new WaitCommand(.3));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addSequential(new ReturnByVector(-.5));
    	addSequential(new TurnByGyro(-60, 2));
    	addSequential(new AutoLiftCommand(RobotMap.scaleHeight));
    	addSequential(new AutoIntake(false));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addParallel(new AutoLiftCommand(RobotMap.cubeHeight));
    }
}
