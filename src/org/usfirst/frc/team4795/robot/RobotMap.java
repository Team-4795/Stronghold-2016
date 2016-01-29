package org.usfirst.frc.team4795.robot;
	
public enum RobotMap {
	LEFT_MOTOR_1	(0),
	LEFT_MOTOR_2	(1),
	RIGHT_MOTOR_1	(2),
	RIGHT_MOTOR_2	(3),
	ARM_MOTOR 		(4),
	INTAKE_MOTOR 	(5);
	
	public final int value;
	
	RobotMap(int value) {
		this.value = value;
	}
}