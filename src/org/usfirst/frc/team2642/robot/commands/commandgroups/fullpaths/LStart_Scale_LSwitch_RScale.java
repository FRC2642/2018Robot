package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.LStart_LSwitch;
import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.LSwitchToRScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LStart_Scale_LSwitch_RScale extends CommandGroup {

    public LStart_Scale_LSwitch_RScale() {
    	addSequential(new LStart_LSwitch());
    	addSequential(new LSwitchToRScale());
    }
}
