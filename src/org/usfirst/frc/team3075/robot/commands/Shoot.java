package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Shoot extends CommandGroup {
    
    public  Shoot() {
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
    	Components.cameraServoAngle.setAngle(Constants.shootAngle);
    	addParallel(new CenterOnTarget());
    	addSequential(new Wait(), 1);
    	addParallel(new PrepareTrajectory());

//    	addSequential(new Wait(), 10);
//    	addSequential(Components.ballPusher.OpenCommand());
//    	addSequential(new Wait(), 1.5);
//    	addSequential(Components.ballPusher.CloseCommand());
//    	addSequential(Robot.shooter.setShooterSpeed(0, 0));

    }
}
