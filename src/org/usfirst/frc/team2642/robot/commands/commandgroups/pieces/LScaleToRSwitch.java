package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByPixy;
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
public class LScaleToRSwitch extends CommandGroup {

    public LScaleToRSwitch() {
    	/*addSequential(new TurnByGyro(90, 2));
    	addParallel(new AutoClamp(false));
    	addSequential(new FindCubeCommand(.5, true));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByVector(.5, 11));
    	addSequential(new ReturnByVector(-.5));
    	addParallel(new AutoLiftCommand(RobotMap.switchHeight));
    	addParallel(new AutoTiltIntake(RobotMap.switchTilt));
        addSequential(new TurnByGyro(96, 2));
        addSequential(new DriveByGyro(96, .8, 6, false));
        addSequential(new DriveByGyro(90, .8, 44, false));
        addSequential(new DriveByGyro(90, .7, 50, false));
        addParallel(new AutoLiftCommand(RobotMap.switchHeight));
    	addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
        addSequential(new DriveByGyro(90, .8, 40, false));
        addSequential(new TurnByGyro(180, 2));
        addSequential(new DriveByGyro(180, .8, 6, false));
        addSequential(new AutoIntake(false));
        addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
        addSequential(new DriveByGyro(180, -.8, 7, false));*/
    	
    	addSequential(new DriveByGyro(0, -.8, 24, false));
    	addSequential(new TurnByGyro(90, 2));
        addSequential(new DriveByGyro(90, .8, 44, false));
        addSequential(new DriveByGyro(90, .7, 50, false));
        addSequential(new AutoClamp(false));
        addSequential(new DriveByGyro(90, .8, 70, false));
        addSequential(new TurnByGyro(195, 2));
    	addSequential(new FindCubeCommand(.5, true));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByPixy(.5));
    	addSequential(new WaitCommand(.15));
    	addSequential(new DriveByGyro(180, -.8, 6, false));
    	addParallel(new AutoTiltIntake(RobotMap.switchTilt));
    	addSequential(new AutoLiftCommand(RobotMap.switchHeight));
    	addSequential(new TurnByGyro(180, 2));
    	addSequential(new DriveByGyro(180, .8, 11, false));
        addSequential(new AutoIntake(false));
        addParallel(new AutoTiltIntake(RobotMap.scaleTilt));
        addSequential(new DriveByGyro(180, -.8, 7, false));
    }
}
