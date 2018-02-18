package org.usfirst.frc.team2642.robot.commands.auto.test.basic;

import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Center extends CommandGroup {

    public Center() {
   addSequential(new InchesDrive(50));
   addSequential(new GyroDegreesTurnDrive(90));
   
    }
}
