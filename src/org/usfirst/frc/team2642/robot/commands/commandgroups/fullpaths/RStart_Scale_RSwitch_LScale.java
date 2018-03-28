package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.LScaleToRSwitch;
import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.RStart_LScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RStart_Scale_RSwitch_LScale extends CommandGroup {

    public RStart_Scale_RSwitch_LScale() {
    	addSequential(new RStart_LScale());
    	addSequential(new LScaleToRSwitch());
    }
}
