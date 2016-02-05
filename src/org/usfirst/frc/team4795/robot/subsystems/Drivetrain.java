package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	public static final double WHEEL_DIAMETER_IN = 6.0;
	public static final int ENCODER_TICKS_PER_REV = 2048;
	public static final double ENCODER_TICKS_PER_FT = (ENCODER_TICKS_PER_REV * 48) / (Math.PI * WHEEL_DIAMETER_IN);
	public static final double WHEEL_SEPARATION_IN = 26.797;
	
	private final CANTalon leftMotor1;
	private final CANTalon leftMotor2;
	private final CANTalon rightMotor1;
	private final CANTalon rightMotor2;
	
	private boolean closedLoopMode = false;

	public Drivetrain() {
		leftMotor1 = new CANTalon(RobotMap.LEFT_MOTOR_1.value);
		leftMotor2 = new CANTalon(RobotMap.LEFT_MOTOR_2.value);
		rightMotor1 = new CANTalon(RobotMap.RIGHT_MOTOR_1.value);
		rightMotor2 = new CANTalon(RobotMap.RIGHT_MOTOR_2.value);
		
		disableControl();
		
		leftMotor1.configEncoderCodesPerRev(ENCODER_TICKS_PER_REV);
		rightMotor1.configEncoderCodesPerRev(ENCODER_TICKS_PER_REV);
		
		leftMotor1.reverseSensor(true);
		rightMotor1.reverseSensor(false);
		
		leftMotor1.ConfigFwdLimitSwitchNormallyOpen(true);
		leftMotor1.ConfigRevLimitSwitchNormallyOpen(true);
		leftMotor2.ConfigFwdLimitSwitchNormallyOpen(true);
		leftMotor2.ConfigRevLimitSwitchNormallyOpen(true);
		rightMotor1.ConfigFwdLimitSwitchNormallyOpen(true);
		rightMotor1.ConfigRevLimitSwitchNormallyOpen(true);
		rightMotor2.ConfigFwdLimitSwitchNormallyOpen(true);
		rightMotor2.ConfigRevLimitSwitchNormallyOpen(true);
		
		leftMotor1.configMaxOutputVoltage(12);
		leftMotor2.configMaxOutputVoltage(12);
		rightMotor1.configMaxOutputVoltage(12);
		rightMotor2.configMaxOutputVoltage(12);
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
		if(mode != TalonControlMode.Position && mode != TalonControlMode.Speed) {
		  leftMotor2.changeControlMode(mode);
		  rightMotor2.changeControlMode(mode);
		  closedLoopMode = false;
		} else {
		  leftMotor2.changeControlMode(TalonControlMode.Follower);
		  leftMotor2.set(RobotMap.LEFT_MOTOR_1.value);
		  rightMotor2.changeControlMode(TalonControlMode.Follower);
		  rightMotor2.set(RobotMap.RIGHT_MOTOR_1.value);
		  closedLoopMode = true;
		}
		enableControl();
	}
	
	public void setRaw(double left, double right) {
		leftMotor1.set(left);
		rightMotor1.set(right);
		if(!closedLoopMode) {
		  leftMotor2.set(left);
		  rightMotor2.set(right);
		}
	}
	
	public void setFPID(double F, double P, double I, double D) {
	    leftMotor1.setF(F);
		leftMotor1.setPID(P, I, D);
		rightMotor1.setF(F);
		rightMotor1.setPID(P, I, D);
	}
	
	public void drive(double left, double right) {
		changeControlMode(TalonControlMode.PercentVbus);
		setRaw(left, right);
	}
	
	public void drive(double distance, double F, double P, double I, double D) {
		changeControlMode(TalonControlMode.Position);
		setFPID(F, P, I, D);
		double distanceTicks = distance * ENCODER_TICKS_PER_FT;
		setRaw(leftMotor1.getPosition()+distanceTicks, rightMotor1.getPosition()+distanceTicks);
	}
	
	public void rotateRadians(double angle, double F, double P, double I, double D) {
		changeControlMode(TalonControlMode.Position);
		setFPID(F, P, I, D);
		double distanceTicks = (angle * WHEEL_SEPARATION_IN * ENCODER_TICKS_PER_FT) / 24;
		setRaw(leftMotor1.getPosition()-distanceTicks, rightMotor1.getPosition()+distanceTicks);
	}
	
	public void rotateDegrees(double angle, double F, double P, double I, double D) {
		rotateRadians(Math.toRadians(angle), F, P, I, D);
	}
	
	public double getLeftError() {
		return leftMotor1.getError();
	}
	
	public double getRightError() {
		return rightMotor1.getError();
	}
	
	public double getLeftEncoderPos() {
	  return leftMotor1.getEncPosition();
	}
	
	public double getRightEncoderPos() {
	  return rightMotor1.getEncPosition();
	}
	
	public double getLeftEncoderVel() {
	  return leftMotor1.getEncVelocity();
	}
	
	public double getRightEncoderVel() {
	  return rightMotor1.getEncVelocity();
	}
	
	public double getLeftSpeed() {
	  return leftMotor1.getSpeed();
	}
	
	public double getRightSpeed() {
	  return rightMotor1.getSpeed();
	}

	@Override
	protected void initDefaultCommand() {}
	
}
