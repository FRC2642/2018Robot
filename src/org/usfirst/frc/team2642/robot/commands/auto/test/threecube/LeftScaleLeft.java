package org.usfirst.frc.team2642.robot.commands.auto.test.threecube;

import org.usfirst.frc.team2642.robot.commands.auto.Wait;
import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
import org.usfirst.frc.team2642.robot.commands.drive.LookForWhite;

import cameras.SetCameraSwitchVision;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScaleLeft extends CommandGroup {

    public LeftScaleLeft() {
    		addSequential(new SetCameraSwitchVision(true));
    	    addParallel(new GyroDegreesTurnDrive(5.29));
    	    addParallel(new InchesDrive(196));
    	    addSequential(new Wait(.1));
    	    addParallel(new GyroDegreesTurnDrive(-5.29));
    	    addParallel(new InchesDrive(110));
    	    addSequential(new GyroDegreesTurnDrive(5.29));
    	    addSequential(new LookForWhite(true));
    	   
    }
}
