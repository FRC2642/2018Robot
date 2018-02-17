package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSystem extends Subsystem {
	
	//Intake motors
	VictorSP intakeMotor1= new VictorSP(RobotMap.intakeMotor1Port);

	VictorSP intakeMotor2 = new VictorSP(RobotMap.intakeMotor2Port);
  
    public void initDefaultCommand() {
    }
    
    //Grabs cube
    public void intakeIn() {
    	intakeMotor1.set(.5);
    	intakeMotor2.set(-.5);
    }
    
    //Ejects cube
    public void intakeOut() {
    	intakeMotor1.set(-.5);
    	intakeMotor2.set(.5);
    }
    
    //Stop motors
    public void stopIntake() {
    	intakeMotor1.set(0.0);
    	intakeMotor2.set(0.0);
    }
}

