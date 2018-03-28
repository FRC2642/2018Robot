package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SonarSubsystem extends Subsystem {
	public AnalogInput sonar = new AnalogInput(RobotMap.sonarPort);
    public void initDefaultCommand() {
    	
    }
    
    public double getDistance() {
    	return ((sonar.getVoltage() / (5.0/512)));
    	//old conversion ((5.0/ 1024) / .2)
    }
}