package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ActiveIntake extends Subsystem {
	CANTalon Arm;
	CANTalon Intake;
	public ActiveIntake()
	{
		Arm = new CANTalon(RobotMap.ARM_MOTOR.value);
		Intake = new CANTalon(RobotMap.INTAKE_MOTOR.value);
	}
	@Override
	protected void initDefaultCommand() {
		

	}

}
