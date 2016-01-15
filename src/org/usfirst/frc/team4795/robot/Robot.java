package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.TankDrive;
import org.usfirst.frc.team4795.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

public class Robot extends IterativeRobot {
	
	private static final double PVAL = 0.0;
	private static final double IVAL = 0.0;
	private static final double DVAL = 0.0;

	public static OI oi;
	public static Drivetrain drivetrain;
	
	@Override
	public void robotInit() {
		SmartDashboard.putNumber("P", PVAL);
		SmartDashboard.putNumber("I", IVAL);
		SmartDashboard.putNumber("D", DVAL);
		
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
		/*
		try {
			double p = SmartDashboard.getNumber("P", 0.0);
			double i = SmartDashboard.getNumber("I", 0.0);
			double d = SmartDashboard.getNumber("D", 0.0);
			Scheduler.getInstance().add(new PIDDrive(p, i, d));
		} catch(TableKeyNotDefinedException | IllegalArgumentException ignored) {}
		*/
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
	public void testInit() {
		
	}
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
}
