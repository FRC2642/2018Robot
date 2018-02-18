package org.usfirst.frc.team2642.robot.commands.auto.test.threecube;

import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
import org.usfirst.frc.team2642.robot.commands.drive.resetBothEncoders;

import cameras.SetCameraSwitchVision;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SwitchToSameSideScaleRight extends CommandGroup {

    public SwitchToSameSideScaleRight() {
    	addSequential(new SetCameraSwitchVision(true));
    	addSequential(new InchesDrive(-18.0));
    	addSequential(new GyroDegreesTurnDrive(-90));
    	addSequential(new InchesDrive(48));
    	addSequential(new GyroDegreesTurnDrive(90));
    	addSequential(new InchesDrive(84));
    	addSequential(new GyroDegreesTurnDrive(90));
    	addSequential(new InchesDrive(58));
    	addSequential(new GyroDegreesTurnDrive(90));
    	addSequential(new InchesDrive(20));
    	
    	//induction code
    	addSequential(new resetBothEncoders());
    }
}
