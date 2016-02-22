package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;
import org.usfirst.frc.team4795.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
	public double kP;
	//KP is the proportional scale
	public DriveStraight(double kp)
	{
		requires(Robot.drivetrain);
		kP = kp;
	}
	
	@Override
	protected void initialize() {
		

	}

	@Override
	protected void execute() {
		
		double angle = Robot.drivetrain.gyroscope.getAngle();
		Robot.drivetrain.drive(-1.0, -angle * kP); 
		Timer.delay(0.004);
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}

	@Override
	protected void end() {
		Robot.drivetrain.drive(0,0); 
	}

	@Override
	protected void interrupted() {
		Robot.drivetrain.drive(0,0); 
	}

}
