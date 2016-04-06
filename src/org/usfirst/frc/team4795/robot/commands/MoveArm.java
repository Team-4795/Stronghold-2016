package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;
import org.usfirst.frc.team4795.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command {

	private final double speed;

	public MoveArm(double speed) {
		requires(Robot.arm);
		this.speed = Robot.oi.isManipulatorDriver() ? speed : speed * 1.5;
	}

	@Override
	protected void initialize() {
		Robot.arm.changeControlMode(TalonControlMode.Speed);
		Robot.arm.setPID(Arm.SPEED_P, Arm.SPEED_I, Arm.SPEED_D, Arm.SPEED_F);
		Robot.arm.setRaw(speed);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.arm.setRaw(0.0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
