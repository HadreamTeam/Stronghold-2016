package org.usfirst.frc.team3075.robot;


import org.usfirst.frc.team3075.robot.commands.AutonomousCrossBlock;
import org.usfirst.frc.team3075.robot.commands.AutonomousCrossRotatingPlatform;
import org.usfirst.frc.team3075.robot.commands.AutonomousCrossTerrain;
import org.usfirst.frc.team3075.robot.commands.AutonomousFallingGate;
import org.usfirst.frc.team3075.robot.commands.AutonomousRisingGate;
import org.usfirst.frc.team3075.robot.commands.CenterOnTarget;
import org.usfirst.frc.team3075.robot.commands.GearDown;
import org.usfirst.frc.team3075.robot.commands.GearUp;
import org.usfirst.frc.team3075.robot.commands.InsertBall;
import org.usfirst.frc.team3075.robot.commands.OpenFallingGate;
import org.usfirst.frc.team3075.robot.commands.OpenRisingGate;
import org.usfirst.frc.team3075.robot.commands.PrepareTrajectory;
import org.usfirst.frc.team3075.robot.commands.RotateAndCenter;
import org.usfirst.frc.team3075.robot.commands.RotateAngle;
import org.usfirst.frc.team3075.robot.commands.Shoot;
import org.usfirst.frc.team3075.robot.subsystems.BigArms;
import org.usfirst.frc.team3075.robot.subsystems.Shooter;
import org.usfirst.frc.team3075.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import libPurple.CANTalon3075;
import libPurple.DriveSystem3075;
import libPurple.EncoderTalon3075;
import libPurple.Joystick3075;
import libPurple.Servo3075;
import libPurple.Solenoid3075;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Components
{
	 public static CANTalon3075 leftRear;
	 public static CANTalon3075 leftMiddle;
	 public static CANTalon3075 leftFront;
	 
	 public static CANTalon3075 rightRear;
	 public static CANTalon3075 rightMiddle;
	 public static CANTalon3075 rightFront;
	 
	 
	 public static EncoderTalon3075 leftDriveEncoder;
	 public static EncoderTalon3075 rightDriveEncoder;
	 
	 public static CANTalon3075 shooterTop;
	 public static CANTalon3075 shooterBottom;
	 
	 public static EncoderTalon3075 shooterTopEncoder;
	 public static EncoderTalon3075 shooterBottomEncoder;
	 
	 public static CANTalon3075 winchRear;
	 public static CANTalon3075 winchFront;

//	 public static EncoderTalon3075 shooterTopEncoder;
//	 public static EncoderTalon3075 shooterBottomEncoder;
	 
	 public static Solenoid3075 smallArmPiston;
	 public static Solenoid3075 bigArmPiston;
	 public static Solenoid3075 shifter;
	 public static Solenoid3075 ballPusher;
//	 public static Servo3075 pushBall;
	 public static Solenoid3075 shooterAnglePiston;
	 
	 public static Servo3075 cameraServoAngle; 
	 
	 public static JoystickButton button1; 
	 public static JoystickButton button2; 
	 public static JoystickButton button3; 
	 public static JoystickButton button4; 
	 public static JoystickButton button5;  
	 public static JoystickButton button6;
	 public static JoystickButton button7;
	 public static JoystickButton button8;
	 public static JoystickButton button9;
	 public static JoystickButton button10;
	 public static JoystickButton button11;
	 public static JoystickButton button12;
	 public static JoystickButton button13;
	 public static JoystickButton button14;
	 public static JoystickButton button15;
	 public static JoystickButton button16;

	 
	 public static Joystick3075 systemStick;
	 public static Joystick3075 driveStick;
	  
	public static void init()
	{
		//Drive Variables for robot A (yaani competing robot)
		leftFront = new CANTalon3075(4);
    	leftFront.setInverted(false);
    	leftMiddle = new CANTalon3075(5);
    	leftMiddle.setInverted(true);
    	leftRear = new CANTalon3075(3);
    	leftRear.setInverted(false);
    	
    	rightFront = new CANTalon3075(7);
    	rightFront.setInverted(false);
    	rightMiddle = new CANTalon3075(6);
    	rightMiddle.setInverted(true);
    	rightRear = new CANTalon3075(8);
    	rightRear.setInverted(true);
		
		//Robot B 
//		leftFront = new CANTalon3075(4);
//    	leftFront.setInverted(false);
//    	leftMiddle = new CANTalon3075(5);
//    	leftRear = new CANTalon3075(3);
//    	leftRear.setInverted(true);
//    	
//    	rightFront = new CANTalon3075(7);
//    	rightFront.setInverted(true);
//    	rightMiddle = new CANTalon3075(6);
//    	rightMiddle.setInverted(true);
//    	rightRear = new CANTalon3075(8);
				
		rightDriveEncoder = new EncoderTalon3075(rightMiddle);
		rightDriveEncoder.reset();
		leftDriveEncoder = new EncoderTalon3075(leftMiddle, true);
		leftDriveEncoder.reset();
		
		leftDriveEncoder.setDistancePerPulse(Constants.leftDistancePerPulse);
		rightDriveEncoder.setDistancePerPulse(Constants.rightDistancePerPulse);
		
		//Shooter Motors
		shooterTop = new CANTalon3075(1);
		shooterTop.setInverted(false);

		shooterBottom = new CANTalon3075(2);
		shooterBottom.setInverted(true);
		
		shooterTopEncoder = new EncoderTalon3075(shooterTop);
		shooterTopEncoder.setDistancePerPulse(10000);
		shooterBottomEncoder = new EncoderTalon3075(shooterBottom);
		shooterBottomEncoder.setDistancePerPulse(10000);
		shooterBottomEncoder.invert(true);

		
		//Pistons
		smallArmPiston = new Solenoid3075(1, 0);
		bigArmPiston  = new Solenoid3075(11, 3, 2);
		ballPusher = new Solenoid3075(6, 7);
		shooterAnglePiston = new Solenoid3075(2, 3);
		shifter  = new Solenoid3075(4, 5);
		
		//Winch (Yaani Kanenet)
		winchRear = new CANTalon3075(9);
		winchFront = new CANTalon3075(10);
		
		cameraServoAngle = new Servo3075(0);
		
		//Joysticks
		driveStick = new Joystick3075(0);
		driveStick.setPower(2);
		systemStick = new Joystick3075(1);
		
		//Initialize Subsystems
		Robot.driveSystem = new DriveSystem3075(new CANTalon3075[]{leftRear, leftMiddle, leftFront}, leftDriveEncoder, new CANTalon3075[]{rightRear, rightMiddle, rightFront}, rightDriveEncoder);
		Robot.driveSystem.setPID(Constants.drivePID);
		Robot.driveSystem.setMaxSpeed(2);
//		Robot.driveSystem.enablePID();
		Robot.driveSystem.setReturnRate(true);
		Robot.driveSystem.enableAccelControl(false);
		Robot.driveSystem.setAccelControl(Constants.frontLimit, Constants.backLimit, Constants.accelP);
		Robot.driveSystem.setToleranceRate(Constants.toleranceRate);
		
		Robot.driveSystem.setPIDLeftDistance(Constants.driveDistanceLeftPID, Constants.driveOutputRange);
		Robot.driveSystem.setPIDRightDistance(Constants.driveDistanceRightPID, Constants.driveOutputRange);
		Robot.driveSystem.setToleranceDistance(Constants.toleranceDistance);

		Robot.shooter = new Shooter();
		Robot.winch = new Winch();
		
		Robot.bigArms = new BigArms(bigArmPiston);
		
		//Buttons
		button1 = new JoystickButton(driveStick, 1);
		button1.whenPressed(smallArmPiston.ToggleCommand());
		
//		button2 = new JoystickButton(systemStick, 2);
//		button2.whenPressed(bigArmPiston.ToggleCommand());
		
		button2 = new JoystickButton(driveStick, 3);
//		button2.toggleWhenPressed(new OpenRisingGate());
		
		button3 = new JoystickButton(systemStick, 3);
		button3.whenPressed(ballPusher.TimedCycle(0.5));
		
		 
		button4 = new JoystickButton(systemStick, 4);
		button4.whenPressed(shooterAnglePiston.ToggleCommand());
		
//		button4 = new JoystickButton(driveStick, 4);
//		button4.whenPressed(new OpenFallingGate());
		 
		button4 = new JoystickButton(driveStick, 4);
		button4.whenPressed(new Shoot());
		
		button5 = new JoystickButton(systemStick, 5);
		button5.whileHeld(Robot.winch.rotateWinch());
		
		button6 = new JoystickButton(systemStick, 6);
		button6.whileHeld(Robot.winch.reverseWinch());
		
//		button7 = new JoystickButton(systemStick, 4);
//		button7.toggleWhenPressed(Robot.shooter.setShooterSpeed(Constants.shooterBallInsertTopSpeed, Constants.shooterBallInsertBottomSpeed));
//		button7.toggleWhenPressed(new PrepareTrajectory());

		button8 = new JoystickButton(systemStick, 2);
		button8.toggleWhenPressed(new InsertBall());
		
//		button9 = new JoystickButton(systemStick, 1);
//		button9.toggleWhenPressed(Robot.shooter.setShooterSpeed(Constants.shooterBallInsertTopSpeed, Constants.shooterBallInsertBottomSpeed));
		
//		button9 = new JoystickButton(systemStick, 2);
//		button9.toggleWhenPressed(new CenterOnTarget());
		
		button10 = new JoystickButton(driveStick, 5);
		button10.whenPressed(cameraServoAngle.goToAngle((Constants.shootAngle + Constants.insertAngle)/2));
		
		button11 = new JoystickButton(systemStick, 1);
		button11.toggleWhenPressed(new Shoot());
		
		button12 = new JoystickButton(systemStick, 9);
		button12.toggleWhenPressed(Robot.shooter.setShooterSpeed(0, -4));
		
		button13 = new JoystickButton(driveStick, 7);
		button13.whenPressed(cameraServoAngle.ButtonToggle(Constants.shootAngle, Constants.insertAngle));
		
		button15 = new JoystickButton(systemStick, 8);
		button15.toggleWhenPressed(Components.shooterAnglePiston.OpenCommand());
		
//
//		button14 = new JoystickButton(systemStick, 12);
//		button14.toggleWhenPressed(Components.shooterAnglePiston.CloseCommand());
		
		
		button7 = new JoystickButton(driveStick, 6);
		button7.toggleWhenPressed(Components.shifter.ToggleCommand());
//		
		button16 = new JoystickButton(driveStick, 3);
		button16.toggleWhenPressed(Robot.shooter.setShooterSpeed(11.6, 11.6));
		
	}
}

  

