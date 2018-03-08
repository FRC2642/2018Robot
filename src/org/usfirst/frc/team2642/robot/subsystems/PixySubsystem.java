package org.usfirst.frc.team2642.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PixySubsystem extends Subsystem {
	AnalogInput pixyAnalog = new AnalogInput(1);
	DigitalInput pixyDigital = new DigitalInput(5);
    public void initDefaultCommand() {
        
    }
    
    public double getCubeCenter() {
    	return (pixyAnalog.getVoltage() / 3.3) * 320;
    }
    
    public boolean isCubeVisible() {
    	return pixyDigital.get();
    }
    
    
}

