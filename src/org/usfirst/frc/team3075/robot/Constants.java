package org.usfirst.frc.team3075.robot;

import libPurple.PIDvalue;

public class Constants
{
	
	//Robot B Constants
	
//	public static final PIDvalue shooterBottomPID = new PIDvalue(0.015, 0.0025, 0.1);
//	public static final PIDvalue shooterTopPID = new PIDvalue(0.009, 0.0015, 0.08);
//
//	public static final double shiftingSpeed = 1.5;
//	
//	public static final PIDvalue drivePID = new PIDvalue(1, 0, 0);
//	
//	public static final PIDvalue driveDistanceLeftPID = new PIDvalue(2, 0.005, 0.01);
//	public static final PIDvalue driveDistanceRightPID = driveDistanceLeftPID;
//	 
//	
//	public static final double driveOutputRange = 0.35;
//	
//	public static final double toleranceRate = 0.1;
//	public static final double toleranceDistance = 0.01;
//	
//	public static final double rightDistancePerPulse = 11822;
//	public static final double leftDistancePerPulse = 11558;
//	
//	public static final double shooterBallInsertTopSpeed = 7.5;
//	public static final double shooterBallInsertBottomSpeed = 7.5;
//	
//	public static final double shooterMaxSpeed = 16000;
//
//	public static final double centerOnTargetP = 0.01;
//	public static final double centerOnTargetI = 0.000135;
//	public static final double centerOnTargetTolerance = 2.5;
//	public static final double centerOnTargetOutputRange = 0.42;
//	
	
	
	
	
	
	//Robot A Constants
	
	public static final PIDvalue shooterTopPID = new PIDvalue(0.008, 0.0011, 0.05);
	public static final PIDvalue shooterBottomPID = new PIDvalue(0.008, 0.0014, 0.05);
	
	public static final double shiftingSpeed = 1.5;
	
	public static final PIDvalue drivePID = new PIDvalue(0.05, 0.000, 0.0);
	
	public static final PIDvalue driveDistanceLeftPID = new PIDvalue(2, 0.005, 0.01);
	public static final PIDvalue driveDistanceRightPID = driveDistanceLeftPID;
	
	public static final PIDvalue driveDistanceRotatePID = new PIDvalue(5, 0, 0.);
	public static final PIDvalue driveDistanceRotateRightPID = new PIDvalue(15, 0, 0.);

	
//	public static final double void enum this abstract implements extends interface super strictfp transient volatile class private protected package import float int char boolean byte long short const new return synchronized continue break switch while for if else do case instanceof native default finally assert null throw try catch; 
	
	
	public static final double driveOutputRange = 0.35;
	
	public static final double centerTarget = 320;
	
	public static final double toleranceRate = 0.1;
	public static final double toleranceDistance = 0.003;
//	
//	public static final double rightDistancePerPulse = 11822;
//	public static final double leftDistancePerPulse = 11558;
//	
	public static final double rightDistancePerPulse = 11554;
	public static final double leftDistancePerPulse = 11121;
	
	public static final double shooterBallInsertTopSpeed = 7.5;
	public static final double shooterBallInsertBottomSpeed = 7.5;
	
//	public static final double shooterMaxSpeed = 16000;

//	public static final double centerOnTargetP = 0.008;
//	public static final double centerOnTargetI = (0.0006) ;
//	public static final double centerOnTargetD = 0.013 ;
//	public static final double centerOnTargetTolerance = 1;
//	public static final double centerOnTargetOutputRange = 0.35;
	
	public static final double centerOnTargetP = 0.004;
	public static final double centerOnTargetI = (0.0002) ;
	public static final double centerOnTargetD = 0.015 ;
	public static final double centerOnTargetTolerance = 1;
	public static final double centerOnTargetOutputRange = 0.35;

	
	public static final double rotate90Deg = 0.46;
	
	public static final double FOV = 68.5;
	
	public static final double imageWidth = 480;
	
	public static final double errorAngle = -4.247;
	
	
	public static final double accellimit = 0.1;
	
	public static final double shootAngle = 175;
	public static final double insertAngle = 120;
	
	public static final double autonomousDistance = 1.9;
	
	public static final double frontLimit = 0.8;
	public static final double backLimit = -0.4;
	public static final double accelP = 1.5;

	
}
