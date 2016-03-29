package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
    
    private final double time;
    private final double speed;
    private long endTime;
    
	public DriveStraight(double time, double speed) {
		requires(Robot.drivetrain);
		this.time = time;
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
	    endTime = ((long) (time * 1000)) + System.currentTimeMillis();
	}

	@Override
	protected void execute() {
		double rotZ = Robot.imu.getDubya()[2];
		Robot.drivetrain.drive(speed, speed - (rotZ * 0.03));
	}

	@Override
	protected boolean isFinished() {
		return System.currentTimeMillis() >= endTime;
	}

	@Override
	protected void end() {
		Robot.drivetrain.drive(0.0, 0.0); 
	}

	@Override
	protected void interrupted() {
	    end();
	}

}
