package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.CANJaguar.JaguarControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class CalibrateArm extends Command {
	
	public CalibrateArm()
	{
		requires(Robot.arm);
	}
	@Override
	protected void initialize() {
		Robot.arm.SetControlMode(JaguarControlMode.Speed.getValue());
		Robot.arm.set(1);
	}

	@Override
	protected void execute() {
		if(!Robot.arm.getForwardLimit()){
			
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.arm.SetControlMode(JaguarControlMode.Position.getValue());
	}

	@Override
	protected void interrupted() {
		Robot.arm.SetControlMode(JaguarControlMode.Position.getValue());
	}

}
