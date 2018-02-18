package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.intake.IntakeCommand;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSystem extends Subsystem {
	
	//Intake motors
	VictorSP intakeMotor1= new VictorSP(RobotMap.intakeMotor1Port);

	VictorSP intakeMotor2 = new VictorSP(RobotMap.intakeMotor2Port);
  
	public IntakeSystem() {
		intakeMotor2.setInverted(true);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeCommand());
    }
    
    //Grabs cube
    public void intakeIn() {
    	intakeMotor1.set(-1);
    	intakeMotor2.set(-1);
    }
    
    //Ejects cube
    public void intakeOut() {
    	intakeMotor1.set(1);
    	intakeMotor2.set(1);
    }
    
    //Stop motors
    public void stop() {
    	intakeMotor1.set(0.0);
    	intakeMotor2.set(0.0);
    }
}

