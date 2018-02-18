package org.usfirst.frc.team2642.robot.commands.auto.test.basic;

import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftBasicLeft extends CommandGroup {

    public LeftBasicLeft() {
     addParallel(new InchesDrive(299.69));
     addParallel(new GyroDegreesTurnDrive(-5.29));
     

     }
}
