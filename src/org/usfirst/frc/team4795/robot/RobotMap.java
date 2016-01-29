package org.usfirst.frc.team4795.robot;
	
public enum RobotMap {
	LEFT_MOTOR_1	(1),
	LEFT_MOTOR_2	(2),
	RIGHT_MOTOR_1	(3),
	RIGHT_MOTOR_2	(4),
	ARM_MOTOR 		(5),
	INTAKE_MOTOR 	(6);
	
	public final int value;
	
	RobotMap(int value) {
		this.value = value;
	}
}