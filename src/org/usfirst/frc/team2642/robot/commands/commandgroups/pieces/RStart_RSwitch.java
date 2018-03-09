
package org.usfirst.frc.team2642.robot.commands.commandgroups.pieces;

import org.usfirst.frc.team2642.robot.commands.drive.DriveByGyro;
import org.usfirst.frc.team2642.robot.commands.drive.TurnByGyro;
import org.usfirst.frc.team2642.robot.commands.misc.StartAutoCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RStart_RSwitch extends CommandGroup {

    public RStart_RSwitch() {
    	addSequential(new StartAutoCommand());
    	addSequential(new DriveByGyro(0, .8, 140, false));
    	addSequential(new TurnByGyro(-90, 1));
    	addSequential(new DriveByGyro(-90, .8, 8, false));
    	//addSequential(new PlaceHolderCommand(.5));
    }
}
