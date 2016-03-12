package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous(double time, double speed) {
    	
    	requires(Robot.drivetrain);
    	requires(Robot.arm);
    	
    	addSequential(new CalibrateArm());
    	addSequential(new DriveStraight(time, speed));
    	
    }
}
