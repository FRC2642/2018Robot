package cameras;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SetCameraSwitchVision extends InstantCommand {
	private boolean state;

	//Sets the current vision mode for the boilerCamera
    public SetCameraSwitchVision(boolean state) {
        super();
        this.state = state;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.setCameraSwitchVision(state);
    }
}
