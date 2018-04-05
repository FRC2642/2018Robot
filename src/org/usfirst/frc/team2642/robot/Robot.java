/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package org.usfirst.frc.team2642.robot;

import org.usfirst.frc.team2642.robot.subsystems.ClimbBrakeSystem;
import org.usfirst.frc.team2642.robot.subsystems.ClimbSystem;
import org.usfirst.frc.team2642.robot.subsystems.DriveTrainSystem;
import org.usfirst.frc.team2642.robot.subsystems.IntakeSystem;
import org.usfirst.frc.team2642.robot.subsystems.IntakeTiltSystem;
import org.usfirst.frc.team2642.robot.subsystems.LiftSystem;
import org.usfirst.frc.team2642.robot.subsystems.PixySubsystem;
import org.usfirst.frc.team2642.robot.subsystems.RampSystem;
import org.usfirst.frc.team2642.robot.subsystems.SonarSubsystem;
import org.usfirst.frc.team2642.robot.utilities.AutoSelector;
import org.usfirst.frc.team2642.robot.utilities.PixyState;
import org.usfirst.frc.team2642.robot.utilities.RoboRioLogger;
import org.usfirst.frc.team2642.robot.utilities.SonarState;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final ClimbBrakeSystem brake = new ClimbBrakeSystem();
	public static final ClimbSystem      climb = new ClimbSystem();
	public static final DriveTrainSystem drive = new DriveTrainSystem();
	public static final IntakeSystem     intake = new IntakeSystem();
	public static final IntakeTiltSystem tilt = new IntakeTiltSystem();
	public static final LiftSystem       lift = new LiftSystem();
	public static final RampSystem       ramp = new RampSystem();
	public static final Compressor compressor = new Compressor();
	//public static PixySubsystem pixy = new PixySubsystem();
	//public static SonarSubsystem sonar = new SonarSubsystem();
	public static OI m_oi;
	
	AnalogInput pixyAnalog = new AnalogInput(RobotMap.pixyAnalogPort);
	DigitalInput pixyDigital = new DigitalInput(RobotMap.pixyDigitalPort);
	AnalogInput sonar = new AnalogInput(RobotMap.sonarPort);
	public static SonarState sonarState = new SonarState(); 
	public static PixyState pixyState = new PixyState(); 
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	public static final RoboRioLogger logger = new RoboRioLogger();
	
	CameraServer server = CameraServer.getInstance();
	
	Thread sonarThread = new Thread(new Runnable() {
		boolean shouldRun = true;
		public void run() {
			while (!RobotState.isDisabled()) {
				if (getDistance() < 14) {
					synchronized(sonarState) {
						sonarState.setIsCubeInRange(true);
					}
				}
				
				synchronized(sonarState) {
					sonarState.setObjectProximity(getDistance());
					shouldRun = sonarState.getShouldRun();
				}
				
				/*try {
				Thread.yield();
				Thread.sleep(20);
				}
				catch (InterruptedException e){
				}*/
			}
		}
			
		private double getDistance() {
		    return ((sonar.getVoltage() / (5.0/512)));
		    //old conversion ((5.0/ 1024) / .2)
		   }
		
	});
	
	Thread pixyThread = new Thread(new Runnable() {
		public void run() {
			boolean shouldRun = true;
			while (!RobotState.isDisabled()) {
				if (isCubeVisible()) {
					synchronized(pixyState) {
						pixyState.setIsCubeVisible(true);
						pixyState.setCubeCenter(getCubeCenter());
					}
				}
				
				synchronized(pixyState) {
					shouldRun = pixyState.getShouldRun();
				}
				
				/*try {
					Thread.yield();
					Thread.sleep(20);
					}
					catch (InterruptedException e){
					}*/
			}
		}
		
	    public double getCubeCenter() {
	    	return (pixyAnalog.getVoltage() / 3.3) * 320;
	    }
	    
	    public boolean isCubeVisible() {
	    	return pixyDigital.get();
	    }
	});
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		while(drive.gyro.isCalibrating());
		m_oi = new OI();
		//m_chooser.addDefault("Default Auto", new DriveByVector(.5, 24));
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		compressor.start();
		
		server.startAutomaticCapture();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		/*synchronized(sonarState) {
			sonarState.setShouldRun(false);
		}
		synchronized(pixyState) {
			pixyState.setShouldRun(false);
		}*/
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Height", lift.liftPot.get());
	}

	
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//m_autonomousCommand = m_chooser.getSelected();
		Robot.drive.invertMotor(true);
		Robot.tilt.invertMotor(false);
		Robot.tilt.initDefaultCommand();
		drive.gyro.reset();
		
		lift.setInputRange(RobotMap.minLift, RobotMap.maxLift);
		tilt.setInputRange(RobotMap.minTilt, RobotMap.maxTilt);
		
		sonarThread.start();
		pixyThread.start();
		
		AutoSelector a = new AutoSelector();
		a.selectAuto();
		m_autonomousCommand = a.autoCommand;
		
		//DONT USE THIS ANYMORE, USE test IN GAME DATA
		
		//m_autonomousCommand = new TestCommandGroup();

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("inches", drive.getDistanceLeft());
		SmartDashboard.putNumber("Tilt", tilt.tiltPot.get());
		SmartDashboard.putNumber("Gyro", drive.gyro.getAngle());
		SmartDashboard.putNumber("Height", lift.liftPot.get());
		//SmartDashboard.putNumber("Sonar", sonar.getDistance());
		//SmartDashboard.putNumber("Pixy", pixy.getCubeCenter());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		SmartDashboard.putString("CurentCommand", ("" + Robot.tilt.getCurrentCommand()));
		Robot.tilt.initDefaultCommand();
		Robot.drive.invertMotor(false);
		Robot.tilt.invertMotor(false);
		synchronized(sonarState) {
			sonarState.setShouldRun(false);
		}
		synchronized(pixyState) {
			pixyState.setShouldRun(false);
		}
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//SmartDashboard.putNumber("SonarVolts", sonar.sonar.getVoltage());
		//SmartDashboard.putNumber("Sonar", sonar.getDistance());
		SmartDashboard.putNumber("Tilt", tilt.tiltPot.get());
		SmartDashboard.putNumber("Height", lift.liftPot.get());
		//SmartDashboard.putNumber("Pixy", pixy.getCubeCenter());
		double sonarValue;
		synchronized(sonarState) {
			sonarValue = sonarState.getObjectProximity();
		}
		SmartDashboard.putNumber("Sonar Distance", sonarValue);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		SmartDashboard.putNumber("LiftPot", lift.liftPot.get());
		SmartDashboard.putNumber("LiftPotPID", lift.liftPot.pidGet());
		SmartDashboard.putNumber("TiltPot", tilt.tiltPot.get());
		SmartDashboard.putNumber("TiltPotPID", tilt.tiltPot.pidGet());
	}
}
