package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.Autonomous;
import org.usfirst.frc.team4795.robot.subsystems.ActiveIntake;
import org.usfirst.frc.team4795.robot.subsystems.Arm;
import org.usfirst.frc.team4795.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
    public static OI oi;
    public static Drivetrain drivetrain;
    public static ActiveIntake intake;
    public static Arm arm;
    
    private SendableChooser autoChooser;
    
    @Override
    public void robotInit() {
        drivetrain = new Drivetrain();
        drivetrain.init();
        intake = new ActiveIntake();
        arm = new Arm();
        oi = new OI();
        oi.init();
        
        CameraSwitcher.init();
        
        autoChooser = new SendableChooser();
    	autoChooser.addDefault("Do Nothing", new Autonomous(0, 0));
    	autoChooser.addObject("Low Bar", new Autonomous(2.5, 0.7));
    	autoChooser.addObject("Rough Terrain", new Autonomous(2.5, 0.7));
    	autoChooser.addObject("Rock Wall", new Autonomous(3.0, 0.7));
    	autoChooser.addObject("Ramparts", new Autonomous(3.0, 0.7));
    	autoChooser.addObject("Moat", new Autonomous(3.0, 0.8));
    	SmartDashboard.putData("Autonomous Chooser", autoChooser);
    }

    @Override
    public void disabledInit() {
        //Robot.drivetrain.calibrateGyroscope();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        Scheduler.getInstance().add((CommandGroup) autoChooser.getSelected());
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {}

    @Override
    public void teleopPeriodic() {
    	SmartDashboard.putNumber("Lever position", oi.MANIPULATOR.getRawAxis(0));
    	SmartDashboard.putNumber("Arm position", arm.getPosRaw());
    	
    	CameraSwitcher.update();
        Scheduler.getInstance().run();
    }

    @Override
    public void testInit() {}

    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }

}
