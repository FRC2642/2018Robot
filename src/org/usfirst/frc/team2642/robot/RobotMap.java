package org.usfirst.frc.team2642.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//PWM
	//RobotDrive
	public static int left = 0;
	public static int right = 1;
	//intake
	public static int rightIntake = 5;
	public static int leftIntake = 4;
	//hoist
	public static int hoist = 3;
	//arm
	public static int arm = 6;
	//climb
	public static int climb = 2;
	
	
	
	public static double climbRaiseSpeed = 1;
	public static double climbLowerSpeed = -1;
	public static int climbEncoderChannelA = 0;
	public static int climbEncoderChannelB = 1;
	public static int climbMaxSetPoint = 1000;
    public static int climbMinSetPoint = 0;
    
	
	
	//Analog
	
	//public static int gyro = 0;
	public static int frontSonar = 1;
	

	//Relay
	
	// USB
	//Cameras
	
	//DIO
	//Encoders
	public static int lEncoder1 = 0;
	public static int lEncoder2 = 1;
	public static int rEncoder1 = 2;
	public static int rEncoder2 = 3;
	//Other
	
	
	//PID
	//Drive
	public static double driveStraightP = 0.05;
	public static double driveStraightI = 0.0;
	public static double driveStraightD = 0.001;
	public static double driveTurnP = 0.15;
	public static double driveTurnI = 0.0;
	public static double driveTurnD = 0.0005;
	public static double driveGTurnP = 0.02;
	public static double driveGTurnI = 0.0;
	public static double driveGTurnD = 0.005;
	
	
	//Variables
	//Drive
	public static double driveForwardOffset = 0.25;
	public static double driveTurnOffset = 0.25;
	public static double driveGTurnOffset = 2.0;
	public static double driveCorrection = -0.2;
	
	public static double driveSwitchCorrection = 0.6;
	
	

	public static int cameraSwitch = 0;
	public static int cameraFront = 1;

	//Image resoulution constants
	public static final int IMG_WIDTH = 320;
	public static final int IMG_HEIGHT = 240;
	
	//gyro
	   public static final double turnController_kP = 0.03;
	    public static final double turnController_kI = 0.00;
	    public static final double turnController_kD = 0.00;
	    public static final double turnController_kF = 0.00;
	    
	    public static final double turnCotrollerToleranceDegrees = 15.0f;

	    // Channels for the wheels
	    public final static int MotorLeft	= 0;
	    public final static int MotorRight	= 1;
	    
	    public static final int driveStick = 2;
	    public static final int auxStick = 3;
	    
	    public static int btnTurn0 = 5;
	    public static int btnTurn90 = 3;
	    public static int btnTurn180 = 4;
	    public static int btnTurn270 = 2;
	    
	   public static double setPointTurn0 = 0.0;
	   public static double setPointTurn90 = 90.0;
	   public static double setPointTurn180 = 180.0;
	   public static double setPointTurn270 = 270.0;
	   
		//ports for sonar
		public static int sonarInputPort = 4;
		public static int sonarOutputPort = 5;
		
		//ports for potentiometers
		public static int tiltPotPort = 0;
		public static int liftPotPort = 1;
		
		//ports for subsystem pneumatic cylinders
		public static int climbCylinderChannel = 0;
		//public static int climbCylinderChannel2 = 1;
		public static int brakeCylinderChannel1 = 2;
		public static int brakeCylinderChannel2 = 3;
		public static int rampCylinderChannel1 = 4;
		public static int rampCylinderChannel2 = 5;
		public static int liftRampCylinderChannel = 6;
		//public static int rightRampCylinderChannel2 = 7;
		
		//ports for subsystem motors
		public static int leftDriveMotorPort = 0;
		public static int rightDriveMotorPort = 1;
		public static int liftMotorPort = 3;
		public static int intakeMotor1Port = 4;
		public static int intakeMotor2Port = 5;
		public static int intakeTiltMotorPort = 6;
		
		//ports for driver station stuff
		public static int auxXboxControllerPort = 1;
		public static int xboxControllerPort = 0;
		
		//ports for encoders 
		public static int leftEncoderChannelA = 0;
		public static int leftEncoderChannelB = 1;
		public static int rightEncoderChannelA = 2;
		public static int rightEncoderChannelB = 3;
		
		//Encoder measurements
		public static final double PULSES_PER_INCH = 0;

	
}


//


