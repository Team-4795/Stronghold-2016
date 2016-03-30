package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight extends Command implements PIDOutput {

	private final double speed;
	private double correction = 0;
	PIDController controller = new PIDController(.01, 0, 0, Robot.imu, this);

	public DriveStraight(double time, double speed) {
		requires(Robot.drivetrain);
		this.setTimeout(time);
		this.speed = speed;
	}

	@Override
	protected void initialize() {
		controller.setSetpoint(0);
		controller.setOutputRange(-0.1, 0.1);
		controller.setInputRange(-360, 360);
		controller.setAbsoluteTolerance(0);
		controller.enable();

		if (SmartDashboard.getNumber("P", -0.1) < 0.0) {
			SmartDashboard.putNumber("P", 0.0);
		}
		if (SmartDashboard.getNumber("I", -0.1) < 0.0) {
			SmartDashboard.putNumber("I", 0.0);
		}
		if (SmartDashboard.getNumber("D", -0.1) < 0.0) {
			SmartDashboard.putNumber("D", 0.0);
		}
		Robot.drivetrain.setRampRate(24);
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Rotation", Robot.imu.getVector()[0]);

		controller.setPID(SmartDashboard.getNumber("P", 0.0),
				SmartDashboard.getNumber("I", 0.0),
				SmartDashboard.getNumber("D", 0.0));
		Robot.drivetrain.drive(speed, speed + correction);
	}

	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}

	@Override
	protected void end() {
		Robot.drivetrain.drive(0.0, 0.0);
		Robot.drivetrain.setRampRate(9999);
		controller.disable();
		Timer.delay(5);
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	public void pidWrite(double output) {
		correction = output;
	}

}
