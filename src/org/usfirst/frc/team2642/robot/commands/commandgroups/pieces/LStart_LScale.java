package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.intake.AutoIntake;
import org.usfirst.frc.team2642.robot.commands.lift.AutoLiftCommand;
import org.usfirst.frc.team2642.robot.commands.misc.StartAutoCommand;
import org.usfirst.frc.team2642.robot.commands.tilt.AutoTiltIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LStart_LScale extends CommandGroup {

    public LStart_LScale() {
    	addSequential(new StartAutoCommand());
    	addSequential(new DriveByGyro(0, .9, 163, false));
    	addSequential(new DriveByGyro(34, .8, 59, false));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new DriveByGyro(25, .8, 2, false));
    	addSequential(new DriveByGyro(10, .8, 2, false));
    	addSequential(new DriveByGyro(0, .8, 20, false));
    	addSequential(new  AutoIntake(false));
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, -.8, 5, false));
    	addParallel(new AutoLiftCommand(RobotMap.cubeHeight));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new DriveByGyro(0, -.8, 5, false));
    	
    }
}
