package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.RStart_RSwitch;
import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.RSwitchToRScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RStart_Switch_RSwitch_RScale extends CommandGroup {

    public RStart_Switch_RSwitch_RScale() {
    	addSequential(new RStart_RSwitch());
    	addSequential(new RSwitchToRScale());
    }
}
