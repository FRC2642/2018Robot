package org.usfirst.frc.team2642.robot.commands.auto.test.threecube;

import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
import org.usfirst.frc.team2642.robot.commands.drive.resetBothEncoders;
import org.usfirst.frc.team2642.robot.commands.drive.resetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScaleToOtherSideSwitchLeft extends CommandGroup {

    public ScaleToOtherSideSwitchLeft() {
       addSequential(new InchesDrive(-18));
       addSequential(new GyroDegreesTurnDrive(90));
       addSequential(new InchesDrive(170));
       addSequential(new GyroDegreesTurnDrive(-90));
       //induction
       addParallel(new InchesDrive(14));
       addSequential(new resetBothEncoders());
       addSequential(new resetGyro());
       
    }
}
