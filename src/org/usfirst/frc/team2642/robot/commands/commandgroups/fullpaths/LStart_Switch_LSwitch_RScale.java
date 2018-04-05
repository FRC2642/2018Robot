package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.LStart_LSwitch;
import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.LSwitchToRScale;
import org.usfirst.frc.team2642.robot.commands.misc.KillThreads;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LStart_Switch_LSwitch_RScale extends CommandGroup {

    public LStart_Switch_LSwitch_RScale() {
        addSequential(new LStart_LSwitch());
        addSequential(new LSwitchToRScale());
        addSequential(new KillThreads());
    }
}
