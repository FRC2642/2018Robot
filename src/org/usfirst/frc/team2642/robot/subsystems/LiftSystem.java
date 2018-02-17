package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class LiftSystem extends PIDSubsystem {
	//Lift motor
	VictorSP liftMotor = new VictorSP(RobotMap.liftMotorPort);
	Potentiometer pot = new AnalogPotentiometer(RobotMap.liftPotPort);
	
	public LiftSystem() {
		super(.001, 0, 0);
    }

    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {
        return 0.0;
    }

    protected void usePIDOutput(double output) {
    }

    //Raises or lowers the lift
    public void moveLift(double speed) {
    	liftMotor.set(speed);
    }
    
    //Off
    public void stop() {
    	liftMotor.set(0.0);
    }
}
