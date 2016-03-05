package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.CalibrateArm;
import org.usfirst.frc.team4795.robot.commands.SetArm;
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

    /*
     * P = 0.500
     * I = 0.002
     * D = 0.100
     * ramp rate = 12
     */
    @Override
    public void teleopPeriodic() {
        SetArm.P = SmartDashboard.getNumber("P", 0.0);
        SetArm.I = SmartDashboard.getNumber("I", 0.0);
        SetArm.D = SmartDashboard.getNumber("D", 0.0);
        SetArm.rampRate = SmartDashboard.getNumber("Ramp Rate", 0.0);
        SmartDashboard.putNumber("Position", Robot.arm.getPosition());
        Scheduler.getInstance().run();
    }

    @Override
    public void testInit() {}

    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }

}
