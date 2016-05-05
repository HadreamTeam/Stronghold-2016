package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OpenRisingGate extends CommandGroup {
    
    public  OpenRisingGate() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	Robot.driveSystem.setPIDLeftDistance(Constants.driveDistanceLeftPID, 0.7);
    	Robot.driveSystem.setPIDRightDistance(Constants.driveDistanceRightPID, 0.7);
    	addSequential(Robot.driveSystem.AutoDrive(0.55, 0.55), 1.5);
    	Robot.driveSystem.setPIDLeftDistance(Constants.driveDistanceLeftPID, Constants.driveOutputRange);
    	Robot.driveSystem.setPIDRightDistance(Constants.driveDistanceRightPID, Constants.driveOutputRange);
    	addSequential(Components.smallArmPiston.CloseCommand());
    	addSequential(Robot.driveSystem.AutoDrive(0.5, 0.5), 1.5);
    	addParallel(Robot.bigArms.close(), 1.5);
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
