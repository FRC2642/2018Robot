package org.usfirst.frc.team2642.robot.commands.auto.test.threecube;

import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
import org.usfirst.frc.team2642.robot.commands.drive.LookForSwitch;
import org.usfirst.frc.team2642.robot.commands.drive.resetBothEncoders;

import cameras.SetCameraSwitchVision;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchLeft extends CommandGroup {

    public LeftSwitchLeft() {
    	addSequential(new SetCameraSwitchVision(true));
    	addSequential(new GyroDegreesTurnDrive(5.29));
    	addSequential(new InchesDrive(108));
    	addSequential(new LookForSwitch(true));
    	addSequential(new resetBothEncoders());
    	//drop block code
    }
}
