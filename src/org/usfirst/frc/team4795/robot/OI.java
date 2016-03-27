package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.CalibrateArm;
import org.usfirst.frc.team4795.robot.commands.ManualArm;
import org.usfirst.frc.team4795.robot.commands.MoveArm;
import org.usfirst.frc.team4795.robot.commands.SpinIntake;
import org.usfirst.frc.team4795.robot.commands.ToggleBrake;
import org.usfirst.frc.team4795.robot.commands.ToggleCamera;
import org.usfirst.frc.team4795.robot.triggers.Lever;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

public class OI {
    
    public static final double JOY_DEADZONE = 0.05;
    public static final double LEVER_DEADZONE = 0.05;
    public static final double INTAKE_PWR = 0.4;

    public final Joystick LEFT_JOY = new Joystick(RobotMap.LEFT_JOY.value);
    public final Joystick RIGHT_JOY = new Joystick(RobotMap.RIGHT_JOY.value);
    public final Joystick MANIPULATOR = new Joystick(RobotMap.MANIPULATOR.value);
    

    
    private final JoystickButton OVERRIDE = 
            new JoystickButton(RIGHT_JOY, RobotMap.R_OVERRIDE.value);
    
    public OI() {
    	Command cmdIntakeIn = new SpinIntake(INTAKE_PWR);
    	Command cmdIntakeOut = new SpinIntake(-INTAKE_PWR);
    	Command cmdArmDown = new MoveArm(45);
    	Command cmdArmUp = new MoveArm(-45);
    	Command cmdCalibrateArm = new CalibrateArm();
    	Command cmdToggleCamera = new ToggleCamera();
    	
        new JoystickButton(LEFT_JOY, RobotMap.L_INTAKE_IN.value).whileHeld(cmdIntakeIn);
        new JoystickButton(LEFT_JOY, RobotMap.L_INTAKE_OUT.value).whileHeld(cmdIntakeOut);
        new JoystickButton(LEFT_JOY, RobotMap.L_TOGGLE_CAM.value).whenPressed(cmdToggleCamera);
        new JoystickButton(LEFT_JOY, 1).whenPressed(new ToggleBrake());
        new JoystickButton(LEFT_JOY, 1).whenReleased(new ToggleBrake());
    	new JoystickButton(MANIPULATOR, RobotMap.M_INTAKE_IN.value).whileHeld(cmdIntakeIn);
    	new JoystickButton(MANIPULATOR, RobotMap.M_INTAKE_OUT.value).whileHeld(cmdIntakeOut);
    	new JoystickButton(MANIPULATOR, RobotMap.M_CALIBRATE.value).whenPressed(cmdCalibrateArm);
    	
    	
    	new SharedButton(new JoystickButton(MANIPULATOR, RobotMap.M_ARM_UP.value),
    	                 new JoystickButton(RIGHT_JOY, RobotMap.R_ARM_UP.value),
    	                 OVERRIDE).whileActive(cmdArmUp);
    	new SharedButton(new JoystickButton(MANIPULATOR, RobotMap.M_ARM_DOWN.value),
    	                 new JoystickButton(RIGHT_JOY, RobotMap.R_ARM_DOWN.value),
    	                 OVERRIDE).whileActive(cmdArmDown);
    	
    	
    	

    	
    }
    
    public void init() {
    	Command cmdManualArm = new ManualArm();
    	Lever lever = new Lever();
    	new SharedButton(lever,
    	                 new Button() {public boolean get() {
    	                	 cmdManualArm.cancel();
    	                	 lever.reset();
    	                	 return false;
    	                 }},
    	                 OVERRIDE).whenActive(cmdManualArm);
    }
    
    public boolean isManipulatorDriver() {
        return !OVERRIDE.get();
    }
    
    /**
     * Polls the state of the lever on the arm manipulator board.
     * 
     * @return The lever pos from -1.0 (fully back) to 0.0 (fully forward)
     */
    public double getManipulatorLever() {
    	return MANIPULATOR.getRawAxis(0);
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
    
    private class SharedButton extends Trigger {
        
        private final Trigger primary;
        private final Trigger secondary;
        private final Trigger override;
        
        public SharedButton(Trigger primary, Trigger secondary, Trigger override) {
            this.primary = primary;
            this.secondary = secondary;
            this.override = override;
        }
        
        @Override
        public boolean get() {return override.get() ? secondary.get() : primary.get();}
        
    }
    
}
