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
public class RightSwitchRight extends CommandGroup {

    public RightSwitchRight() {
    	addSequential(new SetCameraSwitchVision(true));
    	addSequential(new GyroDegreesTurnDrive(-35.07));
    	addSequential(new InchesDrive(121.95));
    	addSequential(new GyroDegreesTurnDrive(144.93));
    	addSequential(new InchesDrive(10));
    	addSequential(new LookForSwitch(true));
    	addSequential(new resetBothEncoders());
    	//drop block code
    }
}
