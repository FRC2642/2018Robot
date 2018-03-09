package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.LStart_LSwitch;
import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.LSwitchToLScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LStart_Switch_LSwitch_LScale extends CommandGroup {

    public LStart_Switch_LSwitch_LScale() {
       addSequential(new LStart_LSwitch());
       addSequential(new LSwitchToLScale());
    }
}
