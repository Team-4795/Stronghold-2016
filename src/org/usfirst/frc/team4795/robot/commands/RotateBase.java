package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RotateBase extends Command {
	
	private final double degrees;
	
	public RotateBase(double degrees) {
		requires(Robot.drivetrain);
		this.degrees = degrees;
	}
	
	@Override
	protected void initialize() {
		Robot.drivetrain.rotateDegrees(degrees, 5, 0, 0);
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {return false;}

	@Override
	protected void end() {
		Robot.drivetrain.drive(0.0, 0.0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
