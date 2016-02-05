package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.DriveForward;
import org.usfirst.frc.team4795.robot.commands.TankDrive;
import org.usfirst.frc.team4795.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	public static OI oi;
	public static Drivetrain drivetrain;
	
	@Override
	public void robotInit() {
		oi = new OI();
		drivetrain = new Drivetrain();
	}
	
	@Override
	public void disabledInit() {}
	
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void autonomousInit() {
	    Scheduler.getInstance().add(new DriveForward(5.0));
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void teleopInit() {
		Scheduler.getInstance().add(new TankDrive());
	}
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void testInit() {}
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
}
