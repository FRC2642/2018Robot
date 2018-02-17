package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbSystem extends Subsystem {

	DoubleSolenoid climbHook = new DoubleSolenoid(RobotMap.climbCylinderChannel1, RobotMap.climbCylinderChannel2);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {}
    
    public void deployHook() {
    	climbHook.set(Value.kForward);
    }
    
    public void resetHook() {
    	climbHook.set(Value.kReverse);
    }
}

