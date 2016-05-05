package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.Components;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import libPurple.CANTalon3075;

/**
 *
 */
public class Winch extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static final double winchSpeed = 1;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Command rotateWinch ()
    {
    	return new SetSpeed(Components.winchRear, Components.winchFront, winchSpeed);
    }
    
    public Command reverseWinch ()
    {
    	return new SetSpeed(Components.winchRear, Components.winchFront, -winchSpeed);
    }
    
}

class SetSpeed extends Command
{
	
	CANTalon3075 talon1;
	CANTalon3075 talon2;
	double speed;
	

	public SetSpeed(CANTalon3075 talon1, CANTalon3075 talon2, double speed) {
		super();
		this.talon1 = talon1;
		this.talon2 = talon2;
		this.speed = speed;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		talon1.set(speed);
		talon2.set(speed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		talon1.set(0);
		talon2.set(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}
	
}

