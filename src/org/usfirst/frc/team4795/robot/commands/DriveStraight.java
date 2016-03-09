package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
    
    private final double time;
    public static double P;
    private long endTime;
    private final double speed;
    
    /*
     * Rock Wall
     * Speed = 0.5
     * Time = 3.0
     * P = 0.05
     * 
     * Ramparts
     * Speed = 0.5
     * Time = 2.5
     * P = 0.05
     * 
     * Moat
     * Speed = 0.5
     * Time = 3.0
     * P = 0.05
     */
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
		double rate = Robot.drivetrain.gyroscope.getRate();
		Robot.drivetrain.drive(speed, speed + (rate * P));
	}

	@Override
	protected boolean isFinished() {
		return System.currentTimeMillis() >= endTime;
	}

	@Override
	protected void end() {
		Robot.drivetrain.drive(0,0); 
	}

	@Override
	protected void interrupted() {
	    end();
	}

}
