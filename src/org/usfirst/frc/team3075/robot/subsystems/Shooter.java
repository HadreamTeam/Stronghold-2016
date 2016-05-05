package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import libPurple.PIDGetEncoder;
import libPurple.utils;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private PIDController topPID;
	private PIDController bottomPID;
	
	private PIDGetEncoder shooterTopEncoder;
	private PIDGetEncoder shooterBottomEncoder;

	
	public Shooter()
	{
		shooterBottomEncoder = new PIDGetEncoder(Components.shooterBottomEncoder, true);
		shooterTopEncoder = new PIDGetEncoder(Components.shooterTopEncoder, true);
		
		topPID = new PIDController(Constants.shooterTopPID.kP,Constants.shooterTopPID.kI,
				Constants.shooterTopPID.kD, shooterTopEncoder, Components.shooterTop);
		
		bottomPID = new PIDController(Constants.shooterBottomPID.kP,Constants.shooterBottomPID.kI,
				Constants.shooterBottomPID.kD, shooterBottomEncoder, Components.shooterBottom);
		
		topPID.setOutputRange(-1, 1);
		topPID.setInputRange(-200000, 200000);
		bottomPID.setOutputRange(-1, 1);
		bottomPID.setInputRange(-200000, 200000);
		
		topPID.setAbsoluteTolerance(500);
		bottomPID.setAbsoluteTolerance(500);

	
	
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualShooter());
    }
    
    public void setSpeed(double speed)
    {
    	setSpeed(speed, speed);
    }
    
    public void setSpeed(double topSpeed, double bottomSpeed)
    {
    	topPID.setSetpoint(topSpeed);
    	bottomPID.setSetpoint(bottomSpeed);

    	Components.shooterTop.set(topPID.get());
    	Components.shooterBottom.set(bottomPID.get());
    	
    	//DriverStation.reportError("\n" + shooterTopEncoder.pidGet(), false);


    }
    
    public Command setShooterSpeed(double topSpeed, double bottomSpeed)
    {
    	return new SetShooterSpeed(topSpeed, bottomSpeed);
    }
    
    public void setRaw(double speed)
    {
    	setRaw(speed, speed);
    }
    
    public void setRaw(double top, double bottom)
    {
    	Components.shooterTop.set(top);
    	Components.shooterBottom.set(bottom);
    }
    
    
    public void enablePID()
    {
    	topPID.enable();
    	bottomPID.enable();
    }
    
    public void disablePID()
    {
    	topPID.disable();
    	bottomPID.disable();
    }
}

class ManualShooter extends Command
{
	
	public ManualShooter() {
		// TODO Auto-generated constructor stub
		requires(Robot.shooter);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
//		utils.requires(this, Components.systemStick);
		Robot.shooter.disablePID();
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.shooter.disablePID();
		Robot.shooter.setRaw(-(Components.systemStick.getRawAxis(2) - 1) / 2);
//		Robot.shooter.setRaw(Components.systemStick.getRawAxis(1)*-1);

		SmartDashboard.putNumber("shooter bottom speed", Components.shooterBottomEncoder.getRate());
		SmartDashboard.putNumber("shooter top speed", Components.shooterTopEncoder.getRate());		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}

class SetShooterSpeed extends Command
{
	private double topSpeed;
	private double bottomSpeed;
	
	public SetShooterSpeed(double topSpeed, double bottomSpeed) {
		// TODO Auto-generated constructor stub
		this.topSpeed = topSpeed;
		this.bottomSpeed = bottomSpeed;
		requires(Robot.shooter);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.shooter.enablePID();

		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
//		topSpeed = Preferences.getInstance().getDouble("testspeed", 0);
//		bottomSpeed = topSpeed;
		
		if(topSpeed == 0 && bottomSpeed == 0)
		{
			Robot.shooter.disablePID();
			Robot.shooter.setRaw(0);
		}
		else
		{
			Robot.shooter.setSpeed(topSpeed, bottomSpeed);
		}	
		
		SmartDashboard.putNumber("shooter bottom speed", Components.shooterBottomEncoder.getRate());
		SmartDashboard.putNumber("shooter top speed", Components.shooterTopEncoder.getRate());
		
//		Robot.shooter.setSpeed(SmartDashboard.getNumber("Speed Shooter"));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
//		Robot.shooter.setSpeed(0);
//		Robot.shooter.disablePID();
		
	}
	
}





