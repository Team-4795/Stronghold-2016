package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.CalibrateArm;
import org.usfirst.frc.team4795.robot.commands.ManualArm;
import org.usfirst.frc.team4795.robot.subsystems.ActiveIntake;
import org.usfirst.frc.team4795.robot.subsystems.Arm;
import org.usfirst.frc.team4795.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

    public static OI oi;
    public static Drivetrain drivetrain;
    public static ActiveIntake intake;
    public static Arm arm;
    
    private CameraServer cameraServer;
    
    @Override
    public void robotInit() {
        drivetrain = new Drivetrain();
        drivetrain.init();
        intake = new ActiveIntake();
        arm = new Arm();
        oi = new OI();
        
        try {
            cameraServer = CameraServer.getInstance();
            cameraServer.setQuality(10);
            cameraServer.startAutomaticCapture();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void autonomousInit() {
        Scheduler.getInstance().add(new CalibrateArm());
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {}

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
