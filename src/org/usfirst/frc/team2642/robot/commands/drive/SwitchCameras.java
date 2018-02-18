package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SwitchCameras extends InstantCommand {

	private boolean Switch;
    public SwitchCameras(boolean Switch) {
    	this.Switch = Switch;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Switch){
    		CameraServer.getInstance().removeCamera("Switch");
    		Robot.cameraSwitch = CameraServer.getInstance().startAutomaticCapture("Switch", RobotMap.cameraSwitch);
    		Robot.cameraSwitch.setFPS(10);
    		Robot.cameraSwitch.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);

    	}else{
    		CameraServer.getInstance().removeCamera("Switch");
    		Robot.cameraSwitch = CameraServer.getInstance().startAutomaticCapture("Switch", RobotMap.cameraFront);
    		Robot.cameraSwitch.setFPS(10);
    		Robot.cameraSwitch.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
    	}
    }
}
