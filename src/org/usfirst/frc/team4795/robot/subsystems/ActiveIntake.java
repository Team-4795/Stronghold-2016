package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ActiveIntake extends Subsystem {
	
	CANTalon arm;
	CANTalon intake;
	
	public ActiveIntake() {
		arm = new CANTalon(RobotMap.ARM_MOTOR.value);
		intake = new CANTalon(RobotMap.INTAKE_MOTOR.value);
	}
	
	@Override
	protected void initDefaultCommand() {}

}
