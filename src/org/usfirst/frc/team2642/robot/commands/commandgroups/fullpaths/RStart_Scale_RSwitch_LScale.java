package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.RStart_RSwitch;
import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.RSwitchToLScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RStart_Scale_RSwitch_LScale extends CommandGroup {

    public RStart_Scale_RSwitch_LScale() {
    	addSequential(new RStart_RSwitch());
    	addSequential(new RSwitchToLScale());
    }
}
