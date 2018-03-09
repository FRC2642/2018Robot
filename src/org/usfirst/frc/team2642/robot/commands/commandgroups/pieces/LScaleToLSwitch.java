package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByVector;
import org.usfirst.frc.team2642.robot.commands.drive.ReturnByVector;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.intake.AutoIntake;
import org.usfirst.frc.team2642.robot.commands.lift.AutoLiftCommand;
import org.usfirst.frc.team2642.robot.commands.misc.FindCubeCommand;
import org.usfirst.frc.team2642.robot.commands.tilt.AutoTiltIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LScaleToLSwitch extends CommandGroup {

    public LScaleToLSwitch() {
    	addSequential(new TurnByGyro(161, 2));
    	addSequential(new FindCubeCommand(.5, true));
    	addSequential(new DriveByVector(.5, 12));
    	addParallel(new AutoIntake(true));
    	addSequential(new AutoLiftCommand(RobotMap.switchHeight));
    	addParallel(new AutoTiltIntake(RobotMap.switchTilt));
    	addSequential(new DriveByGyro(163, .8, 6, false));
    	addSequential(new AutoIntake(false));
    	addSequential(new DriveByGyro(163, -.8, 6, false));
    	addSequential(new ReturnByVector(-.5));
    	/*addSequential(new PlaceHolderCommand(1.5));
    	addSequential(new TurnByGyro(125, 2));
    	addSequential(new DriveByGyro(125, .8, 18, false));*/
    }
}
