package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.tilt.TiltIntakeCommand;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class IntakeTiltSystem extends PIDSubsystem {
	
	//Motor to tilt intake arm
	VictorSP intakeTiltMotor = new VictorSP(RobotMap.intakeTiltMotorPort);
    
	public AnalogPotentiometer tiltPot = new AnalogPotentiometer(RobotMap.tiltPotPort); 
	
    public IntakeTiltSystem() {
    	//P, I, and D values
    	super(.001, 0, 0);
    	disable();
    	intakeTiltMotor.setInverted(true);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TiltIntakeCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }    
    //Tilt the intake 
    public void tilt(double speed) {
    	intakeTiltMotor.set(speed);
    }
    
    //Off
    public void stop() {
    	intakeTiltMotor.set(0.0);
    }

}
