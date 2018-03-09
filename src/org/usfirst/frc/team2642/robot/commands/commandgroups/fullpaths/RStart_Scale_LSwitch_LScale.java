package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.LScaleToLSwitch;
import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.RStart_LScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RStart_Scale_LSwitch_LScale extends CommandGroup {

    public RStart_Scale_LSwitch_LScale() {
    	addSequential(new RStart_LScale());
    	addSequential(new LScaleToLSwitch());
    }
}
