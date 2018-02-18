/*
 * Official 2642 Prayer to the FIRST Robotics Gods:
 * 
 * We pray to Dean, Woodie, and Don
 * for success in our matches
 * and for the spirit of FIRST to fill us 
 * with Gracious Professionalism(TM) and Coopertition(TM).
 * 
 * We pray to the Robonauts, Cheesy Poofs, Highrollers,
 * Simbotics, Beach Bots, and Robowranglers
 * for the strength of vision tracking.
 * May we always find our targets.
 * 
 * We again pray to the aforementioned teams,
 * for the strength of our robot as a whole.
 * May our systems work without fail
 * no matter if they include hardware or software.
 * 
 * We pray to the control systems, and National Instruments,
 * for if we do not appease them we shall fail,
 * as the RoboRio may not continue to work.
 * Please have mercy.
 * 
 * We pray to the Robot Inspectors and the scale
 * as our robot is quite fat and needs a diet.
 * By the weight sensor may we succeed
 * so that we may compete for another day.
 * 
 * We pray to the drivers station
 * and the FMS
 * because if it messes up
 * Alannah and (some how still) noah get blamed
 * 
 * We pray to the FTA,
 * so that we may ensure swift connections
 * and accurate cameras for our drivers.
 * You know they need them!
 * 
 * We pray to Sid, in hopes we dont disappoint him
 * because hes the reason we have auto
 * and hes the best engineering mentor
 * (that was an order, by the way)
 * 
 * and lily
 * just to annoy Austin
 * 
 * We pray to Victor 
 * in hopes he plugged in the batteries
 * because its time to 
 * power up(tm)
 * 
 * And finally, we pray to the power of memes,
 * for without memes we would not have made it through this year.
 * 
 * 
 * al's a butt
 * 
 * In the name of our founder,
 * we now say
 * Kamen.
 */

package org.usfirst.frc.team2642.robot;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.usfirst.frc.team2642.robot.commands.auto.*;
import org.usfirst.frc.team2642.robot.commands.auto.test.basic.Center;
import org.usfirst.frc.team2642.robot.commands.auto.test.basic.LeftBasicLeft;
import org.usfirst.frc.team2642.robot.commands.auto.test.basic.RightBasicRight;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.CenterScaleLeft;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.CenterScaleRight;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.CenterSwitchLeft;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.CenterSwitchRight;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.LeftScaleLeft;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.LeftScaleRight;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.LeftSwitchLeft;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.LeftSwitchRight;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.RightScaleLeft;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.RightScaleRight;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.RightSwitchLeft;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.RightSwitchRight;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.ScaleToOtherSideSwitchLeft;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.ScaleToOtherSideSwitchRight;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.ScaleToSameSideSwitchLeft;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.ScaleToSameSideSwitchRight;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.SwitchToOtherSideScaleLeft;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.SwitchToOtherSideScaleRight;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.SwitchToSameSideScaleLeft;
import org.usfirst.frc.team2642.robot.commands.auto.test.threecube.SwitchToSameSideScaleRight;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
import org.usfirst.frc.team2642.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
@SuppressWarnings("unused")
public class Robot extends IterativeRobot {

	public static final ClimbBrakeSystem brake = new ClimbBrakeSystem();
	public static final ClimbSystem      climb = new ClimbSystem();
	public static final DriveTrainSystem drive = new DriveTrainSystem();
	public static final IntakeSystem     intake = new IntakeSystem();
	public static final IntakeTiltSystem tilt = new IntakeTiltSystem();
	public static final LiftSystem       lift = new LiftSystem();
	public static final RampSystem       ramp = new RampSystem();
	public static final Compressor compressor = new Compressor();
	public static OI m_oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	//Subsystems
		
		
		
		
		public static OI oi;

		//Cameras
		public static UsbCamera cameraSwitch;
		
		public static MjpegServer cameraFront;

		Command autonomousCommand;
		
	

	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		SmartDashboard.putString("Code Version", "0.1.0");
		oi = new OI();

		//Camera instances
		cameraSwitch = CameraServer.getInstance().startAutomaticCapture("Switch", RobotMap.cameraSwitch);
		
		cameraFront = new MjpegServer("Front", 0);
			//Camera resolutions
		cameraSwitch.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
		//cameraGear.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);

		//Camera FPS
		cameraSwitch.setFPS(10);
		
		cameraSwitch.setPixelFormat(VideoMode.PixelFormat.kMJPEG);

		
		
		//Turns off vision by default
		setCameraSwitchVision(false);
		
		//auto stuff
		CenterSwitchLeft CenterSwitchLeft = new CenterSwitchLeft();
		
	}
	
	//Changes camera mode for the boiler camera
	public static void setCameraSwitchVision(boolean enabled) {
		if (enabled) {    //Vision Mode
			cameraSwitch.setBrightness(0);
			cameraSwitch.setExposureManual(0);
		} else {        //Driving Mode
			cameraSwitch.setBrightness(30);
			cameraSwitch.setExposureManual(35);
		}
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
	
		
		//Al- fix this you shmuck
		cameraSwitch.setFPS(10);
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0)
                {
            if(OI.dial1.get()) {
            	//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah
            	//Dial 1 left Swift 
            	if(gameData.charAt(0) == 'L')
      		  {
            		autonomousCommand = new LeftSwitchLeft();
            				
      		  } 
            	else {
            		autonomousCommand = new LeftSwitchRight();
      		  }
            	if(gameData.charAt(1) == 'L')
            	{
            		if(gameData.charAt(0) == 'L')
            		{
            			autonomousCommand = new SwitchToSameSideScaleLeft();
            			
            		}
            		else
            		{
            			autonomousCommand = new SwitchToOtherSideScaleLeft();
            		}
            	}
            	//right side start
            	else
            		{
            		if(gameData.charAt(0) == 'L')
            		{
            			autonomousCommand = new SwitchToOtherSideScaleRight();
            			
            		}
            		else
            		{
            			autonomousCommand = new SwitchToSameSideScaleRight();
            		} 
            		}
            
            }
            // Center Switch
            	if(OI.dial2.get()) {
            		if(gameData.charAt(0) == 'L')
            		{
            			autonomousCommand = new CenterSwitchLeft();
            		}
            		else
            		{
            			autonomousCommand = new CenterSwitchRight();
            		}
            		if(gameData.charAt(1) == 'L')
            		{
            			if(gameData.charAt(0) == 'L')
            			{
            				
                    			autonomousCommand = new SwitchToSameSideScaleLeft();
                    			
                    		}
                    		else
                    		{
                    			autonomousCommand = new SwitchToOtherSideScaleLeft();
                    		}
                    	}
                    	//right side start
                    	else
                    		{
                    		if(gameData.charAt(0) == 'L')
                    		{
                    			autonomousCommand = new SwitchToOtherSideScaleRight();
                    			
                    		}
                    		else
                    		{
                    			autonomousCommand = new SwitchToSameSideScaleRight();
                    		} 
            				
            			}
            		}
            	
            	//Right Switch
            	if(OI.dial3.get()) {
            		if(gameData.charAt(0) == 'L')
            		{
            			autonomousCommand = new RightSwitchLeft();
            		}
            		else
            		{
            			autonomousCommand = new RightSwitchRight();
            		}
            		if(gameData.charAt(1) == 'L')
            		{
            			if(gameData.charAt(0) == 'L')
            			{
            				
                    			autonomousCommand = new SwitchToSameSideScaleLeft();
                    			
                    		}
                    		else
                    		{
                    			autonomousCommand = new SwitchToOtherSideScaleLeft();
                    		}
                    	}
                    	//right side start
                    	else
                    		{
                    		if(gameData.charAt(0) == 'L')
                    		{
                    			autonomousCommand = new SwitchToOtherSideScaleRight();
                    			
                    		}
                    		else
                    		{
                    			autonomousCommand = new SwitchToSameSideScaleRight();
                    		} 
            				
            			}
            		}
            		
            	}
            	//right basic
            	if(OI.dial4.get()) {
            		autonomousCommand = new RightBasicRight();
            	}
            	//center Basic
            	if(OI.dial5.get()) {
            		autonomousCommand = new Center();
            	}
            	//left basic
            	if(OI.dial6.get()) {
            		autonomousCommand = new LeftBasicLeft();
            	}
            	//right scale
            	if(OI.dial7.get()) {
            		if(gameData.charAt(0) == 'L')
            		{
            			autonomousCommand = new RightScaleLeft();
            		}
            		else
            		{
            			autonomousCommand = new RightScaleRight();
            		}
            		if(gameData.charAt(1) == 'L')
            		{
            			if(gameData.charAt(0) == 'L')
            			{
            				
                    			autonomousCommand = new ScaleToSameSideSwitchLeft();
                    			
                    		}
                    		else
                    		{
                    			autonomousCommand = new ScaleToOtherSideSwitchLeft();
                    		}
                    	}
                    	//right side start
                    	else
                    		{
                    		if(gameData.charAt(0) == 'L')
                    		{
                    			autonomousCommand = new ScaleToOtherSideSwitchRight();
                    			
                    		}
                    		else
                    		{
                    			autonomousCommand = new ScaleToSameSideSwitchRight();
                    		} 
            				
            			}
            		}
            		
            	
            	//center scale
            	if(OI.dial8.get()) {
            		if(gameData.charAt(0) == 'L')
            		{
            			autonomousCommand = new CenterScaleLeft();
            		}
            		else
            		{
            			autonomousCommand = new CenterScaleRight();
            		}
            		if(gameData.charAt(0) == 'L')
        			{
        				
                			autonomousCommand = new ScaleToSameSideSwitchLeft();
                			
                		}
                		else
                		{
                			autonomousCommand = new ScaleToOtherSideSwitchLeft();
                		}
                	}
                	//right side start
                	else
                		{
                		if(gameData.charAt(0) == 'L')
                		{
                			autonomousCommand = new ScaleToOtherSideSwitchRight();
                			
                		}
                		else
                		{
                			autonomousCommand = new ScaleToSameSideSwitchRight();
                		} 
        				
        			}
            		
            	
            	//left scale
            	if(OI.dial9.get()) {
            		if(gameData.charAt(0) == 'L')
            		{
            			autonomousCommand = new LeftScaleLeft();
            		}
            		else
            		{
            			autonomousCommand = new LeftScaleRight();
            		}
            		if(gameData.charAt(0) == 'L')
        			{
        				
                			autonomousCommand = new ScaleToSameSideSwitchLeft();
                			
                		}
                		else
                		{
                			autonomousCommand = new ScaleToOtherSideSwitchLeft();
                		}
                	}
                	//right side start
                	else
                		{
                		if(gameData.charAt(0) == 'L')
                		{
                			autonomousCommand = new ScaleToOtherSideSwitchRight();
                			
                		}
                		else
                		{
                			autonomousCommand = new ScaleToSameSideSwitchRight();
                		} 
        				
        			}
            		
            	
            	
            
		 
                
		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro", DriveTrainSystem.getGyro());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		setCameraSwitchVision(false);
		DriveTrainSystem.resetGyro();
		
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		//Sends general vision information to the Smart Dashboard

		SmartDashboard.putNumber("Gyro", DriveTrainSystem.getGyro());
	
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	//	LiveWindow.run();
	}
}
