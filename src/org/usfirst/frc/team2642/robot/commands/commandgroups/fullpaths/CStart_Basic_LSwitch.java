package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.CStart_LSwitchBasic;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CStart_Basic_LSwitch extends CommandGroup {

    public CStart_Basic_LSwitch() {
    	addSequential(new CStart_LSwitchBasic());
    }
}
