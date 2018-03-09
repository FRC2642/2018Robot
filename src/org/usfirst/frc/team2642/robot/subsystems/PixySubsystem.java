package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PixySubsystem extends Subsystem {
	AnalogInput pixyAnalog = new AnalogInput(RobotMap.pixyAnalogPort);
	DigitalInput pixyDigital = new DigitalInput(RobotMap.pixyDigitalPort);
    public void initDefaultCommand() {
        
    }
    
    public double getCubeCenter() {
    	return (pixyAnalog.getVoltage() / 3.3) * 320;
    }
    
    public boolean isCubeVisible() {
    	return pixyDigital.get();
    }
    
    
}

