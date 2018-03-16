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
import org.usfirst.frc.team2642.robot.commands.tilt.AutoTiltIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RScaleToLSwitch extends CommandGroup {

    public RScaleToLSwitch() {
    	addSequential(new TurnByGyro(-170, 2));
    	addParallel(new AutoClamp(false));
    	addSequential(new FindCubeCommand(.5, true));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByVector(.5, 24));
    	addSequential(new ReturnByVector(-.5));
        addSequential(new TurnByGyro(-90, 2));
        addSequential(new DriveByGyro(-90, .8, 47, false));
        addSequential(new DriveByGyro(-90, .6, 50, false));
        addParallel(new AutoLiftCommand(RobotMap.switchHeight));
    	addParallel(new AutoTiltIntake(RobotMap.switchTilt));
        addSequential(new DriveByGyro(-90, .8, 53, false));
        addSequential(new TurnByGyro(-180, 2));
        addSequential(new DriveByGyro(-180, .8, 12, false));
        addSequential(new AutoIntake(false));
    }
}
