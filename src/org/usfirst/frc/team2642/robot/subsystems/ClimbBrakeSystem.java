package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbBrakeSystem extends Subsystem {

	public DoubleSolenoid brakeCylinder = new DoubleSolenoid(RobotMap.brakeCylinderChannel1, RobotMap.brakeCylinderChannel2);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void deployBrake() {
    	brakeCylinder.set(Value.kForward);
    }
    public void resetBrake() {
    	brakeCylinder.set(Value.kReverse);
    }
}

