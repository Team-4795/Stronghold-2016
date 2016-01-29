package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANJaguar.JaguarControlMode;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ActiveIntake extends Subsystem {
	
	CANJaguar arm;
	CANJaguar intake;
	public ActiveIntake() {
		arm = new CANJaguar(RobotMap.ARM_MOTOR.value);
		intake = new CANJaguar(RobotMap.INTAKE_MOTOR.value);
		
		arm.disableControl();
		intake.disableControl();
		
		arm.setControlMode(JaguarControlMode.Position.getValue());
		intake.setControlMode(JaguarControlMode.Speed.getValue());
		
		arm.setPositionMode(arm.kQuadEncoder, 2048, 5, 0, 0);
		intake.setSpeedMode(intake.kQuadEncoder,2048, 5, 0, 0);
		
		arm.enableControl();
		intake.enableControl();
	}
	
	public void liftArm() {
		
	}
	
	@Override
	protected void initDefaultCommand() {}
	
}
