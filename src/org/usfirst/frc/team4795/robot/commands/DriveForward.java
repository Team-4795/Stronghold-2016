package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {

	private double distance;
	
    public DriveForward(double feet) {
    	requires(Robot.drivetrain);
    	distance = feet;
    }

    protected void initialize() {
    	Robot.drivetrain.startPositionMode(10, 0, 0);
    }

    protected void execute() {
    	Robot.drivetrain.drive(distance, distance);
    }

    protected boolean isFinished() {return false;}

    protected void end() {}

    protected void interrupted() {}
    
}
