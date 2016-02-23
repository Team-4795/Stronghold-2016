package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command {
	private double direction;
	public MoveArm(double direction){
		requires(Robot.arm);
	}
	
	@Override
	protected void initialize() {
		double throttle = (1.0 - Robot.oi.DRIVER_LEFTJOY.getThrottle()) / 2.0;
		Robot.arm.setRaw(direction * throttle);
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {return false;}

	@Override
	protected void end() {
		Robot.arm.setRaw(0);
	}

	@Override
	protected void interrupted() {
		Robot.arm.setRaw(0);
	}

}
