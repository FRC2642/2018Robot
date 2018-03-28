package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.intake.IntakeCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSystem extends Subsystem {
	
	//Intake motors
	VictorSP intakeMotor1= new VictorSP(RobotMap.intakeMotor1Port);
	VictorSP intakeMotor2 = new VictorSP(RobotMap.intakeMotor2Port);
	
	//DigitalInput limit = new DigitalInput();
	
	Solenoid closeIntakeCylinder = new Solenoid(RobotMap.closeIntakeCylinderChannel);
	Solenoid openIntakeCylinder = new Solenoid(RobotMap.openIntakeCylinderChannel);
  
	public IntakeSystem() {
		intakeMotor2.setInverted(false);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeCommand());
    }
    
    //Grabs cube
    public void intakeIn() {
    	intakeMotor1.set(-.75);
    	intakeMotor2.set(-.75);
    }
    
    //Ejects cube
    public void intakeOut() {
    	intakeMotor1.set(.75);
    	intakeMotor2.set(.75);
    }
    
    public void intakeOut(double speed) {
    	intakeMotor1.set(speed);
    	intakeMotor2.set(speed);
    }
    
    public void closeIntake() {
    	closeIntakeCylinder.set(true);
    	openIntakeCylinder.set(false);
    }
    
    public void releaseIntake() {
    	closeIntakeCylinder.set(false);
    	openIntakeCylinder.set(false);
    }
    
    public void openIntake() {
    	openIntakeCylinder.set(true);
    	closeIntakeCylinder.set(false);
    }
    
    //Stop motors
    public void stop() {
    	intakeMotor1.set(0.0);
    	intakeMotor2.set(0.0);
    }
}

