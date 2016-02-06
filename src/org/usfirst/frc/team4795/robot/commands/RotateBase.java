package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RotateBase extends Command {
	
	private final double degrees;
	private final double F;
	private final double P;
	private final double I;
	private final double D;
	
	public RotateBase(double degrees, double F, double P, double I, double D) {
		requires(Robot.drivetrain);
		this.degrees = degrees;
		this.F = F;
		this.P = P;
		this.I = I;
		this.D = D;
	}
	
	@Override
	protected void initialize() {
		Robot.drivetrain.rotateDegrees(degrees, F, P, I, D);
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
