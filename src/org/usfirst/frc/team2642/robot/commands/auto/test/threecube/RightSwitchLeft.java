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
public class RightSwitchLeft extends CommandGroup {

    public RightSwitchLeft() {
    	addSequential(new SetCameraSwitchVision(true));
    	addSequential(new InchesDrive(54));
    	addSequential(new GyroDegreesTurnDrive(-90.0));
    	addSequential(new InchesDrive(140.0));
    	addSequential(new GyroDegreesTurnDrive(90.0));
    	addSequential(new InchesDrive(54));
    	addSequential(new LookForSwitch(true));
    	addSequential(new resetBothEncoders());
    	//drop block code
    }
}
