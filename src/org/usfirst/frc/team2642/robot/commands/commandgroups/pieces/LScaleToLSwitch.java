package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByPixy;
import org.usfirst.frc.team2642.robot.commands.drive.ReturnByVector;
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
public class LScaleToLSwitch extends CommandGroup {

    public LScaleToLSwitch() {
    	addParallel(new AutoClamp(false));
    	addSequential(new TurnByGyro(165, 1.5));
    	addSequential(new FindCubeCommand(.5, true));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByPixy(.5));
    	addSequential(new DriveByGyro(163, -.8, 3, false));
    	addSequential(new WaitCommand(.3));
    	addParallel(new AutoTiltIntake(RobotMap.switchTilt));
    	addSequential(new AutoLiftCommand(RobotMap.switchHeight));
    	addSequential(new DriveByGyro(163, .8, 4, false));
    	addSequential(new AutoIntake(false));
    	addSequential(new DriveByGyro(163, -.8, 3, false));
    	addSequential(new ReturnByVector(-.5));
    	/*addSequential(new PlaceHolderCommand(1.5));
    	addSequential(new TurnByGyro(125, 2));
    	addSequential(new DriveByGyro(125, .8, 18, false));*/
    }
}
