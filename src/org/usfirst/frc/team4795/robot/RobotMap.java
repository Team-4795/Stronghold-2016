package org.usfirst.frc.team4795.robot;
	
public enum RobotMap {
	LEFT_MOTOR	(1),
	RIGHT_MOTOR	(3);
	
	public final int value;
	
	RobotMap(int value) {
		this.value = value;
	}
}