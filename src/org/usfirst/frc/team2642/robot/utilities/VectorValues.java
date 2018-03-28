package org.usfirst.frc.team2642.robot.utilities;

import org.usfirst.frc.team2642.robot.RobotMap;

public final class VectorValues {
	public static double vectorComponentX = 0;
	public static double vectorComponentY = 0;
	public static double lastEncoderPulses = 0;
	
	public static double getMagnitude() {
		return Math.sqrt(Math.pow(vectorComponentX - (4 * RobotMap.PULSES_PER_INCH), 2) + Math.pow(vectorComponentY, 2));
	}
	
	public static double getAngle() {
		System.out.println("Magnitude: " + (getMagnitude() / RobotMap.PULSES_PER_INCH));
		return (Math.acos((vectorComponentY / RobotMap.PULSES_PER_INCH) / (getMagnitude() / RobotMap.PULSES_PER_INCH)) * (180 / Math.PI));
	}
	
	public static void reset() {
		vectorComponentX = 0;
		vectorComponentY = 0;
		lastEncoderPulses = 0;
	}
}
