package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.CalibrateArm;
import org.usfirst.frc.team4795.robot.commands.ManualArm;
import org.usfirst.frc.team4795.robot.commands.MoveArm;
import org.usfirst.frc.team4795.robot.commands.SpinIntake;
import org.usfirst.frc.team4795.robot.subsystems.Lever;
import org.usfirst.frc.team4795.robot.subsystems.PrimaryArmDown;
import org.usfirst.frc.team4795.robot.subsystems.PrimaryArmUp;
import org.usfirst.frc.team4795.robot.subsystems.SecondaryArmDown;
import org.usfirst.frc.team4795.robot.subsystems.SecondaryArmUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

public class OI {
    
    public static final double JOY_DEADZONE = 0.05;

    public final Joystick LEFT_JOY = new Joystick(RobotMap.LEFT_JOY.value);
    public final Joystick RIGHT_JOY = new Joystick(RobotMap.RIGHT_JOY.value);
    public final Joystick MANIPULATOR = new Joystick(RobotMap.MANIPULATOR.value);
    private RobotMap driver = RobotMap.SECONDARY;
    
    
    public OI() {
    	
    	Command intakeIn = new SpinIntake(0.4);
    	Command intakeOut = new SpinIntake(-0.4);
    	Command manualArm = new ManualArm();
    	Command secondaryArmDown = new MoveArm(45);
    	Command secondaryArmUp = new MoveArm(-45);
    	Command primaryArmDown = new MoveArm(45);
    	Command primaryArmUp = new MoveArm(-45);
    	
    	JoystickButton buttonIntakeIn = new JoystickButton(MANIPULATOR, RobotMap.SECONDARY_INTAKE_IN.value);
    	JoystickButton buttonIntakeOut = new JoystickButton(MANIPULATOR, RobotMap.SECONDARY_INTAKE_OUT.value);
    	JoystickButton rightTrigger = new JoystickButton(RIGHT_JOY, RobotMap.BUTTON_THROTTLE_ARM.value);
    	
    	new JoystickButton(MANIPULATOR, 3).whenPressed(new CalibrateArm());
    	
    	Trigger triggerPrimaryArmUp = new PrimaryArmUp(this);
    	Trigger triggerPrimaryArmDown = new PrimaryArmDown(this);
    	
    	Trigger triggerSecondaryArmUp = new SecondaryArmUp(this);
    	Trigger triggerSecondaryArmDown = new SecondaryArmDown(this);

    	Lever lever =  new Lever(this);
    	lever.whenActive(manualArm);

    	triggerSecondaryArmUp.cancelWhenActive(manualArm);
    	triggerSecondaryArmDown.cancelWhenActive(manualArm);
    	
    	triggerSecondaryArmUp.whileActive(secondaryArmUp);
    	triggerSecondaryArmDown.whileActive(secondaryArmDown);
    	
    	buttonIntakeIn.whileHeld(intakeIn);
    	buttonIntakeOut.whileHeld(intakeOut);

    	rightTrigger.cancelWhenPressed(manualArm);
    	
    	
    	triggerPrimaryArmUp.whileActive(primaryArmUp);
    	triggerPrimaryArmDown.whileActive(primaryArmDown);
    	
    }
    
    public RobotMap getCurrentDriver() {
    	if(RIGHT_JOY.getTrigger()) {
    		return RobotMap.PRIMARY;
    	} else {
    		return RobotMap.SECONDARY;
    	}
    }
    
    public double getLeverPosition() {
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
    
}
