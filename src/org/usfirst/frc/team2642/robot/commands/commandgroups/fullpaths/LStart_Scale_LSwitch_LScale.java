package org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths;

import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.LScaleToLSwitch;
import org.usfirst.frc.team2642.robot.commands.commandgroups.pieces.LStart_LScale;
import org.usfirst.frc.team2642.robot.commands.misc.KillThreads;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LStart_Scale_LSwitch_LScale extends CommandGroup {

    public LStart_Scale_LSwitch_LScale() {
        addSequential(new LStart_LScale());
        //addSequential(new LScaleToLSwitch());
        addSequential(new KillThreads());
    }
}
