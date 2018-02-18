package org.usfirst.frc.team2642.robot.commands.auto.test.threecube;


import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;

import org.usfirst.frc.team2642.robot.commands.drive.resetBothEncoders;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SwitchToOtherSideScaleLeft extends CommandGroup {

    public SwitchToOtherSideScaleLeft() {
    	addSequential(new InchesDrive(-18.0));
    	addSequential(new GyroDegreesTurnDrive(-90));
    	addSequential(new InchesDrive(48));
    	addSequential(new GyroDegreesTurnDrive(-90));
    	addSequential(new InchesDrive(84));
    	addSequential(new GyroDegreesTurnDrive(-90));
    	addSequential(new InchesDrive(58));
    	addSequential(new GyroDegreesTurnDrive(-90));
    	addSequential(new InchesDrive(20));
    	//induction code
    	addSequential(new resetBothEncoders());
    	addSequential(new InchesDrive(-20));
    	addSequential(new GyroDegreesTurnDrive(-90));
    	addSequential(new InchesDrive(148));
    	addSequential(new GyroDegreesTurnDrive(-90));
    }
}
