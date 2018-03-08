package org.usfirst.frc.team2642.robot.utilities;

public class PIDCorrection {
	
	private double pValue;
	public double error;
	
	public PIDCorrection(double pValue)
	{
		this.pValue = pValue;
	}
	
	public double getPValue()
	{
		return pValue;
	}
	
	public void setPValue(double pValue)
	{
		this.pValue = pValue;
	}
	
	public double calculateCorrection(double setPoint, double current)
	{
		error = setPoint - current;
		return (Math.abs(error) * pValue);
	}
}
