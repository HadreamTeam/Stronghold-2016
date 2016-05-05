package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import libPurple.Solenoid3075;

/**
 *
 */
public class BigArms extends Subsystem {
    
	DoubleSolenoid mySol;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public BigArms(DoubleSolenoid mySol)
	{
		this.mySol = mySol;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualControl());
    }
    
    public Command open()
    {
    	return new OpenClose(mySol, true);
    }
    
    public Command close()
    {
    	return new OpenClose(mySol, false);
    }
    
    public Command off()
    {
    	return new Off(mySol);
    }
}

class ManualControl extends Command {

	public ManualControl()
	{
		requires(Robot.bigArms);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void execute() {
		if(Components.systemStick.getPOV() == -1)
//			Components.bigArmPiston.OffCommand().start();
			Components.bigArmPiston.set(Value.kOff);
		
		else if(((Components.systemStick.getPOV() + 90) % 360) < 180)
//			Components.bigArmPiston.OpenCommand().start();
			Components.bigArmPiston.set(Value.kReverse);
		
		else
//			Components.bigArmPiston.CloseCommand().start();
			Components.bigArmPiston.set(Value.kForward);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Components.bigArmPiston.set(Value.kOff);
	}
	
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}
}

class OpenClose extends Command {

	DoubleSolenoid mySol;
	boolean open;
	
    public OpenClose(DoubleSolenoid ds, boolean open) {
    	mySol = ds;
    	this.open = open;
    	requires(Robot.bigArms);
    }

    protected void initialize() {
    }

    protected void execute() {
    	mySol.set(open ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

class Off extends Command{
DoubleSolenoid mySol;
	
    public Off(DoubleSolenoid ds) {
    	mySol = ds;
    	requires(Robot.bigArms);
    }

    protected void initialize() {
    	mySol.set(DoubleSolenoid.Value.kOff);
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}