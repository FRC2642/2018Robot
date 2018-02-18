package org.usfirst.frc.team2642.robot.commands.auto.test.threecube;

import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
//import org.usfirst.frc.team2642.robot.commands.shooter.SetCameraSwitchVision;
import org.usfirst.frc.team2642.robot.commands.drive.LookForSwitch;
import org.usfirst.frc.team2642.robot.commands.drive.resetBothEncoders;

import cameras.SetCameraSwitchVision;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterSwitchLeft extends CommandGroup {

    public CenterSwitchLeft() {
       /**I'm not even sure if this will work with the new FMS
        * This will be very sketchy
        * Im so sorry Austin
        */
    
    	addSequential(new SetCameraSwitchVision(true));
    	addSequential(new InchesDrive(50.0));
    	addSequential(new GyroDegreesTurnDrive(-90));
    	addSequential(new InchesDrive(84.10333333));
    	addSequential(new GyroDegreesTurnDrive(90));
    	addSequential(new LookForSwitch(true));
    	addSequential(new InchesDrive(73));
    	addSequential(new resetBothEncoders());
    	//drop block code
    	addSequential(new InchesDrive(-27));
    	addSequential(new GyroDegreesTurnDrive(-180));
    	addSequential(new InchesDrive(12));
    	
    	
    }
}
