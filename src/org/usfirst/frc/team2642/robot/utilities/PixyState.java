package org.usfirst.frc.team2642.robot.utilities;

public class PixyState {
	private boolean isCubeVisible = false;
	private double cubeCenter = 0.0;
	private boolean shouldRun = true;
	
	public boolean getIsCubeVisible() {
		return isCubeVisible;
	}
	
	public void setIsCubeVisible(boolean value) {
		isCubeVisible = value;
	}
	
	public double getCubeCenter() {
		return cubeCenter;
	}
	
	public void setCubeCenter(double value) {
		cubeCenter = value;
	}
	
	public void reset() {
		isCubeVisible = false;
		cubeCenter = 0.0;
	}
	
	public void setShouldRun(boolean value) {
		shouldRun = value;
	}
	
	public boolean getShouldRun() {
		return shouldRun;
	}
}
