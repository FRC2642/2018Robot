package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.intake.AutoClamp;
import org.usfirst.frc.team2642.robot.commands.intake.AutoIntake;
import org.usfirst.frc.team2642.robot.commands.lift.AutoLiftCommand;
import org.usfirst.frc.team2642.robot.commands.misc.StartAutoCommand;
import org.usfirst.frc.team2642.robot.commands.tilt.AutoTiltIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LStart_RScale extends CommandGroup {

    public LStart_RScale() {
    	addParallel(new AutoClamp(true));
    	addParallel(new AutoTiltIntake(.7));
    	addSequential(new DriveByGyro(0, .9, 122, false));
    	addSequential(new DriveByGyro(20, .9, 3, false));
    	addSequential(new DriveByGyro(40, .9, 3, false));
    	addSequential(new DriveByGyro(60, .9, 3, false));
    	addSequential(new DriveByGyro(80, .9, 3, false));
    	addSequential(new TurnByGyro(90, 2));
    	addSequential(new DriveByGyro(90, .9, 40, false));
    	addSequential(new DriveByGyro(90, .7, 46, false));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new DriveByGyro(90, .9, 14, false));
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, .8, 12, false));
    	addSequential(new AutoIntake(false));
    	addSequential(new DriveByGyro(0, -.9, 12, false));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new AutoLiftCommand(RobotMap.cubeHeight));
    }
}
