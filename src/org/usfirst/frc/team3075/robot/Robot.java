
package org.usfirst.frc.team3075.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3075.robot.commands.AutonomousCrossBlock;
import org.usfirst.frc.team3075.robot.commands.AutonomousCrossRotatingPlatform;
import org.usfirst.frc.team3075.robot.commands.AutonomousCrossTerrain;
import org.usfirst.frc.team3075.robot.commands.AutonomousFallingGate;
import org.usfirst.frc.team3075.robot.commands.AutonomousRisingGate;
import org.usfirst.frc.team3075.robot.commands.ShootAndEject;
import org.usfirst.frc.team3075.robot.commands.Wait;
import org.usfirst.frc.team3075.robot.subsystems.BigArms;
import org.usfirst.frc.team3075.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3075.robot.subsystems.Gears;
import org.usfirst.frc.team3075.robot.subsystems.Shooter;
import org.usfirst.frc.team3075.robot.subsystems.Winch;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;
import libPurple.AnalogPressureSensor;
import libPurple.DriveSystem3075;
import libPurple.ImageDetection3075;
import libPurple.Rectangle;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem(); // <-- Secret code do not enter
	public static DriveSystem3075 driveSystem;
	public static Shooter shooter;
	public static Winch winch;
	public static Gears gears;
	public static BigArms bigArms;
    public static ImageDetection3075 imageDetection;
    public static USBCamera c;
    public static AnalogPressureSensor pressure;

    

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	Components.init();
    	pressure = new AnalogPressureSensor(0);
    	driveSystem.disablePID();
        chooser = new SendableChooser();
        chooser.addDefault("Don't do anything", new Wait());
//        chooser.addObject("Drive - no traps!", Robot.driveSystem.AutoDrive(1, 1));
        chooser.addObject("Drive - no traps!", Robot.driveSystem.AutoDrive(Constants.autonomousDistance, Constants.autonomousDistance));
        chooser.addObject("Shoot without moving", new ShootAndEject());
        chooser.addObject("Falling bridge", new AutonomousFallingGate());
        chooser.addObject("Rising gate", new AutonomousRisingGate());
        chooser.addObject("4 swings", new AutonomousCrossRotatingPlatform());
        chooser.addObject("Rough terrain", new AutonomousCrossTerrain());
        chooser.addObject("Block", new AutonomousCrossBlock());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto modeses", chooser);
        c = new USBCamera("cam0");
        c.setBrightness(7);
        CameraServer.getInstance().startAutomaticCapture(c);
//        c.setWhiteBalanceHoldCurrent();
//        c.setExposureManual(Preferences.getInstance().getInt("exp", 0));
//        CameraServer.getInstance().startAutomaticCapture("cam0");
        imageDetection = new ImageDetection3075();
    	Components.cameraServoAngle.setAngle(Constants.shootAngle);
    	
    	Components.shifter.set(Value.kForward);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	try
    	{
    		if(c==null)
			{
		    	c = new USBCamera("cam0");
		        c.setBrightness(7);
		        CameraServer.getInstance().startAutomaticCapture(c);
			}
    	} catch(Exception e){}
    }
	
	public void disabledPeriodic() {
		try
    	{
			SmartDashboard.putNumber("Pressure", pressure.readPressure());
			if(c==null)
			{
		    	c = new USBCamera("cam0");
		        c.setBrightness(7);
		        CameraServer.getInstance().startAutomaticCapture(c);
			}
    	} catch(Exception e){}
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	Components.cameraServoAngle.setAngle(Constants.shootAngle);
        autonomousCommand = (Command) chooser.getSelected();
        Components.shifter.set(Value.kForward);
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	Components.shifter.set(Value.kForward);
        driveSystem.update();
        SmartDashboard.putNumber("XxX_Left_Distance_XxX" , Components.leftDriveEncoder.getDistance());
        SmartDashboard.putNumber("XxX_Right_Distance_XxX" , Components.rightDriveEncoder.getDistance());
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        Components.leftDriveEncoder.reset();
        Components.rightDriveEncoder.reset();
        

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        driveSystem.update();
        Scheduler.getInstance().run();
//        c.setExposureHoldCurrent();
        
        SmartDashboard.putNumber("XxX_Left_Distance_XxX" , Components.leftDriveEncoder.getDistance());
        SmartDashboard.putNumber("XxX_Right_Distance_XxX" , Components.rightDriveEncoder.getDistance());
        SmartDashboard.putNumber("Pressure", pressure.readPressure());
        
//        Components.cameraServoAngle.setAngle(Preferences.getInstance().getDouble("angle", 0));
        
        Rectangle rect = null;
		try {
			rect = imageDetection.getRectangle();
			rect.setTargetRatio(imageDetection.targetRatio);
			SmartDashboard.putNumber("Image Hieght" , rect.getHeight());
			SmartDashboard.putNumber("Image Width" , rect.getWidth());
			SmartDashboard.putNumber("Center x" , rect.getCenter().getX());
			SmartDashboard.putNumber("Center diff", rect.getCenter().getX() - Constants.centerTarget);
			SmartDashboard.putNumber("Target Angle" , rect.getAngle());
			SmartDashboard.putNumber("Target to Center Angle" , rect.getAngle() - Constants.errorAngle);






		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SmartDashboard.putNumber("Image Hieght", -1);
			SmartDashboard.putNumber("Image Width" , -1);
			SmartDashboard.putNumber("Center x" , -1);
		} 
		
		SmartDashboard.putNumber("Drive Right Rate", driveSystem.getRightRate());
		SmartDashboard.putNumber("Drive Left Rate", driveSystem.getLeftRate());


		SmartDashboard.putNumber("accelX", driveSystem.getAccel().getX());
		SmartDashboard.putNumber("accelY", driveSystem.getAccel().getY());
		SmartDashboard.putNumber("accel", driveSystem.getAccel().getZ());
		
//		if(Components.systemStick.getPOV() == -1)
////			Components.bigArmPiston.OffCommand().start();
//			Components.bigArmPiston.set(Value.kOff);
//		
//		else if(((Components.systemStick.getPOV() + 90) % 360) < 180)
////			Components.bigArmPiston.OpenCommand().start();
//			Components.bigArmPiston.set(Value.kReverse);
//		
//		else
////			Components.bigArmPiston.CloseCommand().start();
//			Components.bigArmPiston.set(Value.kForward);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
