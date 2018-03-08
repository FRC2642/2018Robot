package org.usfirst.frc.team2642.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SonarSubsystem extends Subsystem {
	AnalogInput sonar = new AnalogInput(0);
    public void initDefaultCommand() {
    	
    }
    
    public double getDistance() {
    	return (sonar.getVoltage() / (5.0/ 512));
    }
}