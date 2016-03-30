package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;
import org.usfirst.frc.team4795.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManualArm extends Command {

	public ManualArm() {
		requires(Robot.arm);
	}

	@Override
	protected void initialize() {
		Robot.arm.setRampRate(54);
	}

	/*
	 * Arm position: -0.672 -> 0.000 Setpoint: 0.402 -> -1.283
	 */
	@Override
	protected void execute() {
		double setpoint = -0.96875 * Robot.oi.getManipulatorLever() - 0.651;
		Robot.arm.setPosRaw(setpoint, Arm.POS_P, Arm.POS_I, Arm.POS_D);
		SmartDashboard.putNumber("Setpoint", setpoint);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.arm.setRampRate(24);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
