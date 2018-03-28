package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.intake.AutoClamp;
import org.usfirst.frc.team2642.robot.commands.intake.AutoIntake;
import org.usfirst.frc.team2642.robot.commands.lift.AutoLiftCommand;
import org.usfirst.frc.team2642.robot.commands.misc.WaitCommand;
import org.usfirst.frc.team2642.robot.commands.tilt.AutoTiltIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LStart_LScale extends CommandGroup {

    public LStart_LScale() {
    	addParallel(new AutoClamp(true));
    	addParallel(new AutoTiltIntake(.7));
    	addSequential(new DriveByGyro(0, .9, 76, false));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new DriveByGyro(0, .9, 76, false));
    	addSequential(new DriveByGyro(36, .8, 55, false));
    	addSequential(new DriveByGyro(25, .8, 2, false));
    	addSequential(new DriveByGyro(10, .8, 2, false));
    	addSequential(new DriveByGyro(0, .8, 13, false));
    	addSequential(new TurnByGyro(5, 2));
    	addSequential(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new AutoIntake(false));
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, -.8, 20, false));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new AutoLiftCommand(RobotMap.cubeHeight));	
    }
}
