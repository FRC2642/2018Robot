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
public class RStart_RScale extends CommandGroup {

    public RStart_RScale() {
    	addParallel(new AutoTiltIntake(.7));
    	addParallel(new AutoLiftCommand(.64));
    	addParallel(new AutoClamp(true));
    	addSequential(new DriveByGyro(0, .9, 96, false));
    	addSequential(new DriveByGyro(0, .9, 74, false));
    	addSequential(new DriveByGyro(-42, .8, 56, false));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new DriveByGyro(-10, .7, 24, false));
    	addSequential(new DriveByGyro(0, .7, 8, false));
    	addSequential(new TurnByGyro(0, 2));
    	addParallel(new AutoLiftCommand(RobotMap.scaleHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new AutoIntake(false));
    	addSequential(new DriveByGyro(0, -.8, 16, false));
    }
}
