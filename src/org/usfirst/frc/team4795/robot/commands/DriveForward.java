package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForward extends Command {

	private double distance;
	
    public DriveForward(double distance) {
    	requires(Robot.drivetrain);
    	this.distance = distance;
    }

    protected void initialize() {
    	Robot.drivetrain.drive(distance, 0.0, 0.0, 0.0, 0.0);
    }

    protected void execute() {}

    protected boolean isFinished() {return false;}

    protected void end() {
    	Robot.drivetrain.drive(0.0, 0.0);
    }

    protected void interrupted() {
    	end();
    }
    
}
