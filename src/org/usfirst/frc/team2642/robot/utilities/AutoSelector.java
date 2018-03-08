package org.usfirst.frc.team2642.robot.utilities;

import org.usfirst.frc.team2642.robot.OI;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.CStart_Basic_LSwitch;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.CStart_Basic_RSwitch;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.LStart_Scale_LSwitch_LScale;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.LStart_Scale_LSwitch_RScale;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.LStart_Scale_RSwitch_LScale;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.LStart_Scale_RSwitch_RScale;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.LStart_Switch_LSwitch_LScale;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.RStart_Scale_LSwitch_LScale;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.RStart_Scale_LSwitch_RScale;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.RStart_Scale_RSwitch_LScale;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.RStart_Scale_RSwitch_RScale;
import org.usfirst.frc.team2642.robot.commands.commandgroups.fullpaths.RStart_Switch_RSwitch_RScale;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutoSelector {
	
	String gameData = DriverStation.getInstance().getGameSpecificMessage();
	public Command autoCommand;
	
	public void selectAuto() {
		
		//left start
		if(isLStart() && isSwitchFirst() && isLSwitch() && isLScale()) {
			autoCommand = new LStart_Switch_LSwitch_LScale();
		}
		if(isLStart() && isScaleFirst() && isLSwitch() && isLScale()) {
			autoCommand = new LStart_Scale_LSwitch_LScale();
		}
		if(isLStart() && (isScaleFirst() || isSwitchFirst()) && isLSwitch() && isRScale()) {
			autoCommand = new LStart_Scale_LSwitch_RScale();
		}
		if(isLStart() && (isScaleFirst() || isSwitchFirst()) && isRSwitch() && isLScale()) {
			autoCommand = new LStart_Scale_RSwitch_LScale();
		}
		if(isLStart() && (isScaleFirst() || isSwitchFirst()) && isRSwitch() && isRScale()) {
			autoCommand = new LStart_Scale_RSwitch_RScale();
		}
		
		//center start
		if(isCStart() && isLSwitch()) {
			autoCommand = new CStart_Basic_LSwitch();
		}
		if(isCStart() && isRSwitch()) {
			autoCommand = new CStart_Basic_RSwitch();
		}
		
		//right start
		if(isRStart() && isSwitchFirst() && isRSwitch() && isRScale()) {
			autoCommand = new RStart_Switch_RSwitch_RScale();
		}
		if(isRStart() && isScaleFirst() && isRSwitch() && isRScale()) {
			autoCommand = new RStart_Scale_RSwitch_RScale();
		}
		if(isRStart() && (isScaleFirst() || isSwitchFirst()) && isRSwitch() && isLScale()) {
			autoCommand = new RStart_Scale_RSwitch_LScale();
		}
		if(isRStart() && (isScaleFirst() || isSwitchFirst()) && isLSwitch() && isRScale()) {
			autoCommand = new RStart_Scale_LSwitch_RScale();
		}
		if(isRStart() && (isScaleFirst() || isSwitchFirst()) && isLSwitch() && isLScale()) {
			autoCommand = new RStart_Scale_LSwitch_LScale();
		}
	}
	
	public boolean isLStart() {
		if(OI.dial1.get()) {
			return true;
		} else { 
			return false;
		}
	}
	
	public boolean isCStart() {
		if(OI.dial2.get()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isRStart() {
		if(OI.dial3.get()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isSwitchFirst() {
		if(OI.dial4.get()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isScaleFirst() {
		if(OI.dial5.get()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBasicFirst() {
		if(OI.dial6.get()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isLSwitch() {
		if(gameData.charAt(0) == 'L') {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isRSwitch() {
		if(!isLSwitch()) {
			return true;
		} else {
			return false;
		}		
	}
	
	public boolean isLScale() {
		if(gameData.charAt(1) == 'L') {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isRScale() {
		if(!isLScale()) {
			return true;
		} else {
			return false;
		}
	}
	
}
