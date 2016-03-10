package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.ManualArm;
import org.usfirst.frc.team4795.robot.commands.MoveArm;
import org.usfirst.frc.team4795.robot.commands.SpinIntake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
    
    public static final double JOY_DEADZONE = 0.05;

    public final Joystick LEFT_JOY = new Joystick(RobotMap.LEFT_JOY.value);
    public final Joystick RIGHT_JOY = new Joystick(RobotMap.RIGHT_JOY.value);
    
    public OI() {
    	new JoystickButton(LEFT_JOY, RobotMap.BUTTON_INTAKE_IN.value).whileHeld(new SpinIntake(0.4));
    	new JoystickButton(LEFT_JOY, RobotMap.BUTTON_INTAKE_OUT.value).whileHeld(new SpinIntake(-0.4));
    	
    	JoystickButton ARM_DOWN = new JoystickButton(RIGHT_JOY, RobotMap.BUTTON_ARM_DOWN.value);
    	ARM_DOWN.whileHeld(new MoveArm(45));
    	
    	JoystickButton ARM_UP = new JoystickButton(RIGHT_JOY, RobotMap.BUTTON_ARM_UP.value);
    	ARM_UP.whileHeld(new MoveArm(-45));
    	
    	new JoystickButton(RIGHT_JOY, RobotMap.BUTTON_THROTTLE_ARM.value).whileHeld(new ManualArm());
    }
    
    public double getLeftJoyX() {
        double raw = LEFT_JOY.getX();
        return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
    }
    
    public double getLeftJoyY() {
        double raw = LEFT_JOY.getY();
        return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
    }
    
    public double getRightJoyX() {
        double raw = RIGHT_JOY.getX();
        return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
    }
    
    public double getRightJoyY() {
        double raw = RIGHT_JOY.getY();
        return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
    }
    
}
