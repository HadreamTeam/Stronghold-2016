package org.usfirst.frc.team3075.robot.commands;

import java.awt.Component;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OpenFallingGate extends CommandGroup {
    
    public  OpenFallingGate() {
    	addParallel(Robot.bigArms.open(), 5); //is the the other way around - !open
    	addSequential(new Wait(), 0.2);
    	addSequential(Robot.driveSystem.AutoDrive(-0.70, -0.70), 3);
    	addSequential(Components.smallArmPiston.OpenCommand());
    	addSequential(Robot.driveSystem.AutoDrive(-0.20, -0.20), 1);
    	//yaani shahar niftekh kadima!
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
