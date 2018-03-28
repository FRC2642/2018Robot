package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyroWithTimeOut;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.intake.AutoClamp;
import org.usfirst.frc.team2642.robot.commands.intake.AutoIntake;
import org.usfirst.frc.team2642.robot.commands.lift.AutoLiftCommand;
import org.usfirst.frc.team2642.robot.commands.tilt.AutoTiltIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CStart_RSwitchBasic extends CommandGroup {

    public CStart_RSwitchBasic() {
    	addParallel(new AutoTiltIntake(.7));
    	addParallel(new AutoClamp(true));
    	addSequential(new DriveByGyro(0, .7, 12, false));
    	addParallel(new AutoLiftCommand(RobotMap.switchHeight));
    	addParallel(new AutoTiltIntake(RobotMap.switchTilt));
    	addSequential(new DriveByGyro(45, .7, 96, false));
    	addSequential(new TurnByGyro(0, 2));
    	addSequential(new DriveByGyroWithTimeOut(0, .6, 18, false, 5));
    	addSequential(new AutoIntake(false));
    	addSequential(new DriveByGyro(0, -.7, 60, false));
    	addParallel(new AutoLiftCommand(RobotMap.cubeHeight));
    	addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new TurnByGyro(-50, 2));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByGyro(-50, .7, 57, false));
    	addSequential(new WaitCommand(.3));
    	addSequential(new DriveByGyro(-90, -.7, 32, false));
    	addSequential(new DriveByGyro(-110, .7, 72, false));
    	addSequential(new TurnByGyro(-180, 2));
    	addSequential(new DriveByGyro(-180, .7, 12, false));
    }
}
