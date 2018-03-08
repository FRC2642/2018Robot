package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.RScaleToRSwitch;
import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.RStart_RScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RStart_Scale_RSwitch_RScale extends CommandGroup {

    public RStart_Scale_RSwitch_RScale() {
    	addSequential(new RStart_RScale());
    	addSequential(new RScaleToRSwitch());
    }
}
