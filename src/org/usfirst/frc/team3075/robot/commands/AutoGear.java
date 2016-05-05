package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoGear extends Command {

    public AutoGear() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.gears);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Constants.shiftingSpeed < Robot.driveSystem.getRate())
    	{
    		Components.shifter.set(Value.kForward);
    	}
    	else
    	{
    		Components.shifter.set(Value.kReverse);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
