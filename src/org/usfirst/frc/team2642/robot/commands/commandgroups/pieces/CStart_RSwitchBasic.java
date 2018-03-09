package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.intake.AutoIntake;
import org.usfirst.frc.team2642.robot.commands.lift.AutoLiftCommand;
import org.usfirst.frc.team2642.robot.commands.misc.StartAutoCommand;
import org.usfirst.frc.team2642.robot.commands.tilt.AutoTiltIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CStart_RSwitchBasic extends CommandGroup {

    public CStart_RSwitchBasic() {
    	addSequential(new StartAutoCommand());
    	addSequential(new WaitCommand(.1));
    	addSequential(new DriveByGyro(0, .7, 12, false));
    	addSequential(new DriveByGyro(45, .7, 96, false));
    	addParallel(new AutoLiftCommand(RobotMap.switchHeight));
    	addParallel(new AutoTiltIntake(RobotMap.switchTilt));
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyro(0, .6, 18, false));
    	addSequential(new AutoIntake(false));
    	addSequential(new DriveByGyro(0, -.7, 60, false));
    	addParallel(new AutoLiftCommand(RobotMap.cubeHeight));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new TurnByGyro(-50, 2));
    	addSequential(new DriveByGyro(-50, .7, 48, false));
    	addSequential(new WaitCommand(.5));
    	addSequential(new DriveByGyro(-90, -.7, 25, false));
    	addSequential(new DriveByGyro(-110, .7, 72, false));
    	addSequential(new TurnByGyro(-180, 2));
    	addSequential(new DriveByGyro(-180, .7, 12, false));
    }
}
