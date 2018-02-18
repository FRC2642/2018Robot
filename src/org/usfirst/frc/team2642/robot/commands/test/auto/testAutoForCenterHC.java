package org.usfirst.frc.team2642.robot.commands.test.auto;

import org.usfirst.frc.team2642.robot.commands.auto.Wait;
import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class testAutoForCenterHC extends CommandGroup {

    public testAutoForCenterHC() {
    	//center, blue, LLL
    	//hard code
    	//vision? do I want that for this?
    	//figure out the diddly darn scuttle detection
    
    	
    	//teaching
    	//1. drive foreward
    	//2. turn 90 degrees to the right(?)
    	//3.drive parallel to the DS
    	//4.turn right(?) to face scale
    	//5. drive to scale
    	//6. wait until end of auto
    	//this is not a good(tm) auto program
    	addSequential(new InchesDrive(-60));
    	addSequential(new GyroDegreesTurnDrive(90.0));
    	addSequential(new InchesDrive(-120));
    	addSequential(new GyroDegreesTurnDrive(-90));
    	addSequential(new InchesDrive(-156));
    	addSequential(new Wait(10.0));
    	//does this work? maybe.
    	//Are the inch values completly arbitrary? yes 
    
    
    
    
    }
    
}
