package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.HoldArm;
import org.usfirst.frc.team4795.robot.commands.MoveArm;
import org.usfirst.frc.team4795.robot.commands.SetArm;
import org.usfirst.frc.team4795.robot.commands.SpinIntake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

    public final Joystick LEFT_JOY = new Joystick(0);
    public final Joystick RIGHT_JOY = new Joystick(1);
    
    public OI() {
    	new JoystickButton(LEFT_JOY, RobotMap.BUTTON_INTAKE_IN.value).whileHeld(new SpinIntake(0.2));
    	new JoystickButton(LEFT_JOY, RobotMap.BUTTON_INTAKE_OUT.value).whileHeld(new SpinIntake(-0.2));
    	JoystickButton ARM_DOWN = new JoystickButton(RIGHT_JOY, RobotMap.BUTTON_ARM_DOWN.value);
    	ARM_DOWN.whileHeld(new MoveArm(1.0));
    	ARM_DOWN.whenReleased(new HoldArm());
    	JoystickButton ARM_UP = new JoystickButton(RIGHT_JOY, RobotMap.BUTTON_ARM_UP.value);
    	ARM_UP.whileHeld(new MoveArm(-1.0));
    	ARM_DOWN.whenReleased(new HoldArm());
    	new JoystickButton(RIGHT_JOY, 1).whileHeld(new SetArm());
    }
    
}
