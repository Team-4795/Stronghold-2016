package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	private static final double WHEEL_DIAMETER_IN = 6.0;
	private static final int ENCODER_TICKS_PER_REV = 2048;
	private static final double ENCODER_TICKS_PER_FT = (ENCODER_TICKS_PER_REV * 48) / (Math.PI * WHEEL_DIAMETER_IN);
	
	private final CANTalon leftMotor1;
	private final CANTalon leftMotor2;
	private final CANTalon rightMotor1;
	private final CANTalon rightMotor2;

	public Drivetrain() {
		leftMotor1 = new CANTalon(RobotMap.LEFT_MOTOR_1.value);
		leftMotor2 = new CANTalon(RobotMap.LEFT_MOTOR_2.value);
		rightMotor1 = new CANTalon(RobotMap.RIGHT_MOTOR_1.value);
		rightMotor2 = new CANTalon(RobotMap.RIGHT_MOTOR_2.value);
		
		disableControl();
		
		leftMotor2.changeControlMode(TalonControlMode.Follower);
		rightMotor2.changeControlMode(TalonControlMode.Follower);
		
		leftMotor2.set(RobotMap.LEFT_MOTOR_1.value);
		rightMotor2.set(RobotMap.RIGHT_MOTOR_1.value);
		
		leftMotor1.reverseOutput(false);
		leftMotor2.reverseOutput(true);
		rightMotor1.reverseOutput(false);
		rightMotor2.reverseOutput(true);
		
		enableControl();
	}
	
	public void disableControl() {
		leftMotor1.disableControl();
		leftMotor2.disableControl();
		rightMotor1.disableControl();
		rightMotor2.disableControl();
	}
	
	public void enableControl() {
		leftMotor1.enableControl();
		leftMotor2.enableControl();
		rightMotor1.enableControl();
		rightMotor2.enableControl();
	}
	
	public void changeControlMode(TalonControlMode mode) {
		disableControl();
		leftMotor1.changeControlMode(mode);
		rightMotor1.changeControlMode(mode);
		enableControl();
	}
	
	public void setRaw(double left, double right) {
		leftMotor1.set(left);
		rightMotor1.set(right);
	}
	
	public void setPID(double P, double I, double D) {
		leftMotor1.setPID(P, I, D);
		rightMotor1.setPID(P, I, D);
	}
	
	public void drive(double left, double right) {
		setRaw(0.0, 0.0);
		changeControlMode(TalonControlMode.PercentVbus);
		setRaw(left, right);
	}
	
	public void drive(double distance, double P, double I, double D) {
		setRaw(0.0, 0.0);
		changeControlMode(TalonControlMode.Position);
		double distanceTicks = distance * ENCODER_TICKS_PER_FT;
		setRaw(leftMotor1.getPosition()+distanceTicks, rightMotor1.getPosition()+distanceTicks);
	}

	@Override
	protected void initDefaultCommand() {}
	
}
