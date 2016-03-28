package org.usfirst.frc.team4795.robot;

import java.text.DecimalFormat;

import org.usfirst.frc.team4795.robot.commands.Autonomous;
import org.usfirst.frc.team4795.robot.subsystems.ActiveIntake;
import org.usfirst.frc.team4795.robot.subsystems.Arm;
import org.usfirst.frc.team4795.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4795.robot.subsystems.IMU;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.hal.PDPJNI;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
    public static OI oi;
    public static Drivetrain drivetrain;
    public static ActiveIntake intake;
    public static Arm arm;
    
    private SendableChooser autoChooser;
    
    private double startEnergy = 0;
    public static IMU imu = IMU.getInstance();
    private DecimalFormat f = new DecimalFormat("+000.000;-000.000");
	private double[] pos = new double[3]; // [x,y,z] position data
	private BNO055.CalStatus cal;
	private PowerDistributionPanel PDP = new PowerDistributionPanel();
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
    	startEnergy = PDP.getTotalEnergy();
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
    	if(arm.getForwardLimit()) {
    		arm.zeroPos();
    		arm.motor.clearIAccum();
    	}
    	
    	if(imu.isInitialized()) {
    		pos = imu.getVector();
    		cal = imu.getCalibrationStatus();
    		SmartDashboard.putNumber("Accel", cal.accel);
    		SmartDashboard.putNumber("Gyro", cal.gyro);
    		SmartDashboard.putNumber("Mag", cal.mag);
    		SmartDashboard.putNumber("X", pos[0]);
    		SmartDashboard.putNumber("Y", pos[1]);
    		SmartDashboard.putNumber("Z", pos[2]);
    		
    	}
    	
    	SmartDashboard.putNumber("Power", PDP.getTotalPower());
    	
    	
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
