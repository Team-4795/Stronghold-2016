package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.CameraSwitcher;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleCamera extends Command {
	@Override
	protected void initialize() {
		CameraSwitcher.toggle();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
