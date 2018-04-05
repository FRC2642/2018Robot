package org.usfirst.frc.team2642.robot.utilities;

public class SonarState {
	private boolean isCubeInRange = false;
	private double objectProximity = 0.0;
	private boolean shouldRun = true;
	
	public boolean getIsCubeInRange() {
		return isCubeInRange;
	}
	
	public void setIsCubeInRange(boolean value) {
		isCubeInRange = value;
	}
	
	public double getObjectProximity() {
		return objectProximity;
	}
	
	public void setObjectProximity(double value) {
		objectProximity = value;
	}
	
	public void reset() {
		isCubeInRange = false;
		objectProximity = 0.0;
	}
	
	public void setShouldRun(boolean value) {
		shouldRun = value;
	}
	
	public boolean getShouldRun() {
		return shouldRun;
	}
}