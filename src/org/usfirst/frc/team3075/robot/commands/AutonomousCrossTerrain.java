package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCrossTerrain extends CommandGroup {
    
	public static double myDistance = (Constants.autonomousDistance + 1.5);
    public  AutonomousCrossTerrain() {
    	// yaani tifzoret
        // Add Commands here:
    	Robot.driveSystem.setPIDLeftDistance(Constants.driveDistanceLeftPID, 0.4);
    	Robot.driveSystem.setPIDRightDistance(Constants.driveDistanceRightPID, 0.4);
    	addSequential(Robot.driveSystem.AutoDrive(myDistance, myDistance));
    	Robot.driveSystem.setPIDLeftDistance(Constants.driveDistanceLeftPID, Constants.driveOutputRange);
    	Robot.driveSystem.setPIDRightDistance(Constants.driveDistanceRightPID, Constants.driveOutputRange);
//    	addParallel(new ShootAndEject());
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
    	
    }
}
