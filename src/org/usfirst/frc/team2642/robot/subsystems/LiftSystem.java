package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.lift.LiftCommand;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class LiftSystem extends PIDSubsystem {
	//Lift motor
	VictorSP liftMotor = new VictorSP(RobotMap.liftMotorPort);
	
	public AnalogPotentiometer liftPot = new AnalogPotentiometer(RobotMap.liftPotPort); 

	public LiftSystem() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
		super(.001, 0, 0);
		disable();
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new LiftCommand());
    }

    protected double returnPIDInput() {
    	return liftPot.pidGet();
    }

    protected void usePIDOutput(double output) {
    	moveLift(output);
    }

    //Raises or lowers lift
    public void moveLift(double speed) {
    	/*if ((speed < 0) && (liftPot.get() > RobotMap.minLift)) {
    		liftMotor.set(speed);
    	}
    	else if ((speed > 0) && (liftPot.get() < RobotMap.maxLift)) {
    		liftMotor.set(speed);
    	}
    	else {
    		stop();
    	}*/
    	liftMotor.set(speed);
    }
    
    //Off
    public void stop() {
    	liftMotor.set(0.0);
    }
}
