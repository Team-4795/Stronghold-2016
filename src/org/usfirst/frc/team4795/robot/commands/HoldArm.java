package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HoldArm extends Command {

	public HoldArm()
	{
		requires(Robot.arm);
	}
	
	@Override
	protected void initialize() {
		// begin controlling the speed of the elevator through the encoder
	    // XXX random PID values?
	    Robot.arm.startSpeedMode(-0.5, -0.05, 0);
	    Robot.arm.setRaw(0.001);
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
		

	}

	@Override
	protected void interrupted() {
		

	}

}
