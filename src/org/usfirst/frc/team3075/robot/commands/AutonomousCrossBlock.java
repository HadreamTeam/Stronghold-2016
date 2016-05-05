package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCrossBlock extends CommandGroup {
    
	public static double myDistance = -(Constants.autonomousDistance + 2);
    public  AutonomousCrossBlock() {
    	// yaani gushsheletz
        // Add Commands here:
    	Robot.driveSystem.setPIDLeftDistance(Constants.driveDistanceLeftPID, 0.6);
    	Robot.driveSystem.setPIDRightDistance(Constants.driveDistanceRightPID, 0.6);
    	addSequential(Robot.driveSystem.AutoDrive(myDistance, myDistance));
    	
    	addSequential(new RotateAngle(200, 0.5), 2); //please forgive us
    	
    	Robot.driveSystem.setPIDLeftDistance(Constants.driveDistanceLeftPID, Constants.driveOutputRange);
    	Robot.driveSystem.setPIDRightDistance(Constants.driveDistanceRightPID, Constants.driveOutputRange);
    	
//    	addParallel(new ShootAndEject());
    	
    }
}
