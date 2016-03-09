package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class CalibrateArm extends Command {
	
    private boolean finished;
    
	public CalibrateArm() {
		requires(Robot.arm);
	}
	
	@Override
	protected void initialize() {
	    Robot.arm.changeControlMode(TalonControlMode.PercentVbus);
        Robot.arm.setRaw(0.5);
	}

	@Override
	protected void execute() {
	    if(Robot.arm.getForwardLimit()) {
	        Robot.arm.zeroPos();
	        finished = true;
	    }
	}

	@Override
	protected boolean isFinished() {
		return finished;
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
