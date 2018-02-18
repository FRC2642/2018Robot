package org.usfirst.frc.team2642.robot.commands.auto.test.threecube;

import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
import org.usfirst.frc.team2642.robot.commands.drive.LookForWhite;

 import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterScaleRight extends CommandGroup {

    public CenterScaleRight() {
     
    	addSequential(new InchesDrive(50.0));
    	addSequential(new GyroDegreesTurnDrive(90));
    	addSequential(new InchesDrive(124));
    	addSequential(new GyroDegreesTurnDrive(-90));
    	addSequential(new InchesDrive(100));
    	addSequential(new LookForWhite(true));
    	
    	
    }
}
