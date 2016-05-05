package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RotateAndCenter extends CommandGroup {
	
	public static Command getCommand()
	{
		return new myFuckedUpCommand();
	}
    
    public  RotateAndCenter() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
		DriverStation.reportError("\nhere!", false);

        // arm.
    	try 
    	{
			DriverStation.reportError("\nWorking", false);

    		addSequential(new RotateAngle(Robot.imageDetection.getRectangle().getAngle() - Constants.errorAngle));
//	    	addSequential(new CenterOnTarget(), 4);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DriverStation.reportError("\nCannot", false);
		}
    }
}

class myFuckedUpCommand extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Components.cameraServoAngle.setAngle(Constants.shootAngle);
		CommandGroup fuck = new RotateAndCenter();
		fuck.start();
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
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
