package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
    
    /*
     * <name>:    <speed> <time>
     * Low Bar:       0.4 2.0 
     * Rock Wall:     0.5 3.0
     * Rough Terrain: 0.4 2.0
     * Ramparts:      0.5 2.5
     * Moat:          0.5 3.0
     */
    public Autonomous(double time, double speed) {
    	requires(Robot.drivetrain);
    	requires(Robot.arm);
    	
    	addSequential(new CalibrateArm());
    	addSequential(new DriveStraight(time, speed), 5000);

    	addSequential(new DriveStraight(time, -speed), 5000);
    }
}
