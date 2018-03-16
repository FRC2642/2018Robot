package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByVector;
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
public class RScaleToRSwitch extends CommandGroup {

    public RScaleToRSwitch() {
    	addSequential(new TurnByGyro(-170, 2));
    	addParallel(new AutoClamp(false));
    	addSequential(new FindCubeCommand(.5, true));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByVector(.5, 11));
    	addParallel(new AutoTiltIntake(RobotMap.switchTilt));
    	addSequential(new AutoLiftCommand(RobotMap.switchHeight));
    	addSequential(new DriveByGyro(-163, .8, 6, false));
    	addSequential(new AutoIntake(false));
    	addSequential(new DriveByGyro(-163, -.8, 6, false));
    	/*addSequential(new DriveByGyro(-163, -.8, 18, false));
    	addSequential(new TurnByGyro(-140, 2));
    	addSequential(new DriveByGyro(-140, .8, 19, false));*/
    }
}
