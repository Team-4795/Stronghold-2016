package org.usfirst.frc.team4795.robot;
	
public enum RobotMap {
	LEFT_MOTOR	(1),
	RIGHT_MOTOR	(3),
	ARM_MOTOR (4),
	INTAKE_MOTOR (5);
	
	public final int value;
	
	RobotMap(int value) {
		this.value = value;
	}
}