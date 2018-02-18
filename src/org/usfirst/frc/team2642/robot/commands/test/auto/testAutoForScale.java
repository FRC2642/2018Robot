package org.usfirst.frc.team2642.robot.commands.test.auto;

import org.usfirst.frc.team2642.robot.commands.auto.Wait;
import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class testAutoForScale extends CommandGroup {

    public testAutoForScale() {
    	
    	//all hardcode
    	
    	
    	//runs from left diver station to the auto line
    	addSequential(new InchesDrive (-10));
    	addSequential(new GyroDegreesTurnDrive(5.0));
    	addSequential(new InchesDrive(-134));
        //runs from auto line to white tape line by scale
    	addSequential(new GyroDegreesTurnDrive(-5.0));
    	addSequential(new InchesDrive (-168));
    	addSequential(new Wait(1.0));
    	
    }
}
