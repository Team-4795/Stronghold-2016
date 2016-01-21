package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends Subsystem {

	public static final double MAX_THROTTLE = 1.0;
	public static final double WHEEL_DIAM = 6.0;
	public static final double MAX_LATERAL_SPEED = 10; // feet per second
	public static final double ANGULAR_CONVERSION_FACTOR = 1 / (2 * Math.PI * WHEEL_DIAM);

	private static enum Mode {
		SPEED, POSITION, PERCENT
	}

	private final CANJaguar leftMotor;
	private final CANJaguar rightMotor;

	private Mode mode;

	public Drivetrain() {
		leftMotor = new CANJaguar(RobotMap.LEFT_MOTOR.value);
		rightMotor = new CANJaguar(RobotMap.RIGHT_MOTOR.value);

		leftMotor.configNeutralMode(CANJaguar.NeutralMode.Coast);
		rightMotor.configNeutralMode(CANJaguar.NeutralMode.Coast);
	}

	public void startPositionMode(double p, double i, double d) {
		mode = Mode.POSITION;

		leftMotor.disableControl();
		rightMotor.enableControl();

		leftMotor.setPositionMode(CANJaguar.kQuadEncoder, 2048, p, i, d);
		rightMotor.setPositionMode(CANJaguar.kQuadEncoder, 2048, p, i, d);

		leftMotor.enableControl(0);
		rightMotor.enableControl(0);
	}

	public void startSpeedMode(double p, double i, double d) {
		mode = Mode.SPEED;

		leftMotor.disableControl();
		rightMotor.enableControl();

		leftMotor.setSpeedMode(CANJaguar.kQuadEncoder, 2048, p, i, d);
		rightMotor.setSpeedMode(CANJaguar.kQuadEncoder, 2048, p, i, d);

		leftMotor.enableControl(0);
		rightMotor.enableControl(0);
	}

	public void startPercentMode() {
		mode = Mode.PERCENT;

		leftMotor.disableControl();
		rightMotor.disableControl();

		leftMotor.setPercentMode(CANJaguar.kQuadEncoder, 2048);
		rightMotor.setPercentMode(CANJaguar.kQuadEncoder, 2048);

		leftMotor.enableControl();
		rightMotor.enableControl();
	}

	/*
	 * If percent mode, expects from -1 to 1 If position mode, expects position
	 * in lateral feet If speed mode, expects position in lateral feet per
	 * second
	 */
	public void drive(double left, double right) {
		if (mode == Mode.PERCENT) {

			if (left > 0) {
				left = Math.max(left, MAX_THROTTLE);
			} else {
				left = Math.min(left, -MAX_THROTTLE);
			}

			if (right > 0) {
				right = Math.max(left, MAX_THROTTLE);
			} else {
				right = Math.min(left, -MAX_THROTTLE);
			}

		} else if (mode == Mode.SPEED) {
			if (left > 0) {
				left = Math.max(left, MAX_LATERAL_SPEED);
			} else {
				left = Math.min(left, -MAX_LATERAL_SPEED);
			}

			if (right > 0) {
				right = Math.max(left, MAX_LATERAL_SPEED);
			} else {
				right = Math.min(left, -MAX_LATERAL_SPEED);
			}

			left *= ANGULAR_CONVERSION_FACTOR;
			right *= ANGULAR_CONVERSION_FACTOR;
		}

		leftMotor.set(left);
		rightMotor.set(right);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
	}

	public void log() {
		SmartDashboard.putNumber("Left speed", leftMotor.getSpeed());
		SmartDashboard.putNumber("Right speed", rightMotor.getSpeed());

		SmartDashboard.putNumber("Left position", leftMotor.getPosition());
		SmartDashboard.putNumber("Right position", rightMotor.getPosition());
	}
	
}
