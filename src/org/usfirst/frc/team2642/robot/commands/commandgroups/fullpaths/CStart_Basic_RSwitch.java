package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.CStart_RSwitchBasic;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CStart_Basic_RSwitch extends CommandGroup {

    public CStart_Basic_RSwitch() {
    	addSequential(new CStart_RSwitchBasic());
    }
}
