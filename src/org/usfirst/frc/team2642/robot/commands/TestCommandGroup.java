package org.usfirst.frc.team2642.robot.commands;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.DriveByVector;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.intake.AutoClamp;
import org.usfirst.frc.team2642.robot.commands.intake.AutoIntake;
import org.usfirst.frc.team2642.robot.commands.lift.AutoLiftCommand;
import org.usfirst.frc.team2642.robot.commands.tilt.AutoTiltIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestCommandGroup extends CommandGroup {

    public TestCommandGroup() {
    	/*addParallel(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new AutoLiftCommand(RobotMap.cubeHeight));
    	addSequential(new FindCubeCommand(.4, true));
    	addSequential(new AutoClamp(false));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByVector(.4, 8));
    	addSequential(new ReturnByVector(-.4));
    	addSequential(new TurnByGyro(0,2));*/
    	
    	/*addSequential(new FindCubeCommand(.5, true));
    	addSequential(new AutoClamp(false));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByVector(.5));
    	addSequential(new ReturnByVector(-.5));*/
    	
    	/*addSequential(new AutoLiftCommand(RobotMap.switchHeight));
    	addSequential(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new WaitCommand(1));
    	addSequential(new AutoTiltIntake(RobotMap.scaleTilt));
    	addSequential(new WaitCommand(1));
    	addSequential(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new WaitCommand(1));
    	addSequential(new AutoTiltIntake(RobotMap.scaleTilt));*/
    	
    	addSequential(new AutoLiftCommand(RobotMap.cubeHeight));
    	addSequential(new AutoTiltIntake(RobotMap.cubeTilt));
    	addSequential(new TurnByGyro(135, 1.5));
    	addSequential(new AutoClamp(false));
    	addParallel(new AutoIntake(true));
    	addSequential(new DriveByVector(.5));
    }
}
