package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.LStart_RScale;
import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.RScaleToRSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LStart_Scale_RSwitch_RScale extends CommandGroup {

    public LStart_Scale_RSwitch_RScale() {
    	addSequential(new LStart_RScale());
    	addSequential(new RScaleToRSwitch());
    }
}
