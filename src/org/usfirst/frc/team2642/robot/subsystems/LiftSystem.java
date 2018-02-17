package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class LiftSystem extends PIDSubsystem {
	//Lift motor
	Victor liftMotor = new Victor(RobotMap.liftMotorPort);
   
	AnalogPotentiometer liftPot = new AnalogPotentiometer(RobotMap.liftPotPort); 

	public LiftSystem() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
		super(.001, 0, 0);
		disable();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
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

    //Raises the lift
    public void raiseLift() {
    	liftMotor.set(.7);
    }
    
    //Lowers the lift
    public void lowerLift() {
    	liftMotor.set(-.7);
    }
    
    //Off
    public void stopLift() {
    	liftMotor.set(0.0);
    }
}
