package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import libPurple.utils;

/**
 *
 */
public class CenterOnTarget extends Command {
	
	double error = 0;
	static double sum = 0;
	double output;
	double initError;
	double lastError = 0;
//	PIDController pidCenter;
	
    public CenterOnTarget() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Components.cameraServoAngle.setAngle(Constants.shootAngle);
    	output = Constants.centerOnTargetOutputRange;  
    	try {
			initError = Robot.imageDetection.getRectangle().getCenter().getX() - Constants.centerTarget;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Robot.driveSystem.disablePID();
    	
    	DriverStation.reportError("\nCoT", false);
//    	Robot.driveSystem.setReturnRate(true);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try {
			error = Robot.imageDetection.getRectangle().getCenter().getX() - Constants.centerTarget;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	if(utils.inRange(error, 0, 2))
    	
//    	if(Math.abs(error) < 20 && false)
//    	{
    		DriverStation.reportError(Math.min(Math.max(error*Constants.centerOnTargetP + sum*Constants.centerOnTargetI, -Constants.centerOnTargetOutputRange), Constants.centerOnTargetOutputRange) + "\n", false);
    	
    		//without the if the code is the same as before. just uncomment vvvv
    		Robot.driveSystem.setArcadeDrive(0, Math.min(Math.max(error*Constants.centerOnTargetP + sum*Constants.centerOnTargetI + (error - lastError)*Constants.centerOnTargetD, -Constants.centerOnTargetOutputRange), Constants.centerOnTargetOutputRange));
//    		Robot.driveSystem.setArcadeDrive(0, 0.15);
        	sum += error;
        	lastError = error;

//    	}
//    	else
//    	{
//    		sum = 0;
//    		Robot.driveSystem.setArcadeDrive(0, Math.signum(error) * output);
//    	}
    	

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
//        return (Math.abs(error) < Constants.centerOnTargetTolerance);
    	  return false;
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSystem.setArcadeDrive(0, 0);
    	Robot.driveSystem.disablePID();

    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
