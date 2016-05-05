package org.usfirst.frc.team3075.robot.commands;

import java.sql.DriverAction;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PrepareTrajectory extends Command {

	private double x;
	private double speed = 0;
	
    public PrepareTrajectory() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Components.cameraServoAngle.setAngle(Constants.shootAngle);
		Robot.shooter.enablePID();
    	
    	try {
			x = Robot.imageDetection.getRectangle().getHeight();
			DriverStation.reportError("\n"+x, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			x = -1;
			DriverStation.reportError("FUCKKKK NO IMAGEEE", false);
		}
    	
    	if(x > 50)
    	{
    		Components.shooterAnglePiston.set(Value.kForward);
//        	speed = 0.00541687415*Math.pow(x, 3) - 0.2804239106*Math.pow(x, 2) + 4.438279681*x - 8.330706472;
//    		speed = 0.001905844699*Math.pow(x, 3) - 0.2683710627*Math.pow(x, 2) + 12.49468887*x - 180.745432;
    		//latest V
//    		speed = 0.00009974505971*Math.pow(x, 4) - 0.01754405894*Math.pow(x, 3) + 1.150368526*Math.pow(x, 2) - 33.40413406*x + 374.86;
    		speed = 0.009109627*Math.pow(x, 2)	-1.063691155*x + 41.54026722;
    	}
    	else
    	{
    		Components.shooterAnglePiston.set(Value.kReverse);
//        	speed = 0.0102916*Math.pow(x/2, 4) - 0.645704*Math.pow(x/2, 3) + 15.1497*Math.pow(x/2, 2) - 157.584*x/2 + 625.962;
//    		speed = -0.000407011*Math.pow(x, 4) + 0.0603283*Math.pow(x, 3) - 3.32736*Math.pow(x, 2) + 80.9212*x - 717.927;
    		speed = 19;
    	}
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	SmartDashboard.putNumber("Shooter Setpoint", speed);
    	SmartDashboard.putNumber("Shooter height", x);
    	
    	SmartDashboard.putNumber("shooter bottom speed", Components.shooterBottomEncoder.getRate());
		SmartDashboard.putNumber("shooter top speed", Components.shooterTopEncoder.getRate());

    	Robot.shooter.setSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
