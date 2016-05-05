package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousFallingGate extends CommandGroup {
    
	private static double myDistance = Constants.autonomousDistance - 0.79;
	
    public  AutonomousFallingGate() {
    	addParallel(Robot.bigArms.close(), 3);
    	addSequential(new Wait(), 1.5);
    	addSequential(Robot.driveSystem.AutoDrive(myDistance, myDistance), 2);
    	addSequential(new OpenFallingGate());
    	addSequential(Robot.driveSystem.AutoDrive(3.5, 3.5), 3);
//    	addParallel(new ShootAndEject());
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
    }
}
