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
public class LStart_LSwitch extends CommandGroup {

    public LStart_LSwitch() {
    	addParallel(new AutoClamp(true));
    	addParallel(new AutoTiltIntake(.7));
    	addSequential(new DriveByGyro(.5, .8, 55, false));
    	addParallel(new AutoLiftCommand(RobotMap.switchHeight));
    	addParallel(new AutoTiltIntake(RobotMap.switchTilt));
    	addSequential(new DriveByGyro(0, .8, 55, false));
    	addSequential(new WaitCommand(.3));
    	addSequential(new TurnByGyro(85, 2));
    	addSequential(new AutoIntake(false));
    	addSequential(new DriveByGyro(90, -.8, 5, false));
    }
}
