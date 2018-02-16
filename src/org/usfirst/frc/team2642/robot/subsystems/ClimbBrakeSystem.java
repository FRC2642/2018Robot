package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbBrakeSystem extends Subsystem {

	DoubleSolenoid brake = new DoubleSolenoid(RobotMap.brakeCylinderChannel1, RobotMap.brakeCylinderChannel2);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void deployBrake() {
    	brake.set(Value.kForward);
    }
    public void resetBrake() {
    	brake.set(Value.kReverse);
    }
}

