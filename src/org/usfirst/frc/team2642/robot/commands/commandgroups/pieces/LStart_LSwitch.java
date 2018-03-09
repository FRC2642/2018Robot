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
public class LStart_LSwitch extends CommandGroup {

    public LStart_LSwitch() {
    	addSequential(new StartAutoCommand());
    	addSequential(new DriveByGyro(0, .8, 140, false));
    	addSequential(new TurnByGyro(90, 2));
    	addParallel(new AutoLiftCommand(RobotMap.switchHeight));
    	addParallel(new AutoTiltIntake(RobotMap.switchTilt));
    	addSequential(new AutoIntake(false));
    }
}
