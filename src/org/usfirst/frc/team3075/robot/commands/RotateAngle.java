package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RotateAngle extends CommandGroup {
    
    public  RotateAngle(double deg) {
    	requires(Robot.driveSystem);
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
        // arm.
    	double something = 90 / deg;
    	
    	Robot.driveSystem.setPIDLeftDistance(Constants.driveDistanceRotatePID, Constants.driveOutputRange);
    	Robot.driveSystem.setPIDRightDistance(Constants.driveDistanceRotateRightPID, Constants.driveOutputRange);
    	DriverStation.reportError("\n left: " +Constants.rotate90Deg/something + "right: "  + -Constants.rotate90Deg/something, false);

    	addSequential(Robot.driveSystem.AutoDrive(Constants.rotate90Deg/something, -Constants.rotate90Deg/something));
    	
    	Robot.driveSystem.setPIDLeftDistance(Constants.driveDistanceLeftPID, Constants.driveOutputRange);
    	Robot.driveSystem.setPIDRightDistance(Constants.driveDistanceRightPID, Constants.driveOutputRange);
    }
    
    public  RotateAngle(double deg, double outputRange) {
    	requires(Robot.driveSystem);
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
        // arm.
    	double something = 90 / deg;
    	
    	Robot.driveSystem.setPIDLeftDistance(Constants.driveDistanceRotatePID, outputRange);
    	Robot.driveSystem.setPIDRightDistance(Constants.driveDistanceRotateRightPID, outputRange);
    	DriverStation.reportError("\n left: " +Constants.rotate90Deg/something + "right: "  + -Constants.rotate90Deg/something, false);

    	addSequential(Robot.driveSystem.AutoDrive(Constants.rotate90Deg/something, -Constants.rotate90Deg/something));
    	
    	Robot.driveSystem.setPIDLeftDistance(Constants.driveDistanceLeftPID, Constants.driveOutputRange);
    	Robot.driveSystem.setPIDRightDistance(Constants.driveDistanceRightPID, Constants.driveOutputRange);
    }
}
