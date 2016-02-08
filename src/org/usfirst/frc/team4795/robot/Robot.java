package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.TankDrive;
import org.usfirst.frc.team4795.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

    public static OI oi;
    public static Drivetrain drivetrain;

    @Override
    public void robotInit() {
        drivetrain = new Drivetrain();
        drivetrain.init();
        oi = new OI();
    }

    @Override
    public void disabledInit() {
        Robot.drivetrain.calibrateGyroscope();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {}

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
