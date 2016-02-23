package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.MoveArm;
import org.usfirst.frc.team4795.robot.commands.SpinIntake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

    public final Joystick DRIVER_LEFTJOY = new Joystick(0);
    public final Joystick DRIVER_RIGHTJOY = new Joystick(1);
    
    public final JoystickButton ARM_IN = new JoystickButton(DRIVER_RIGHTJOY, 2);
    public final JoystickButton ARM_OUT = new JoystickButton(DRIVER_RIGHTJOY, 3);;
    public final JoystickButton ARM_UP = new JoystickButton(DRIVER_RIGHTJOY, 4);;
    public final JoystickButton ARM_DOWN = new JoystickButton(DRIVER_RIGHTJOY, 6);;
    public OI() {
    	ARM_IN.whileHeld(new SpinIntake(1));
    	ARM_OUT.whileHeld(new SpinIntake(-1));
    	ARM_UP.whileHeld(new MoveArm(1));
    	ARM_UP.whileHeld(new MoveArm(-1));
    }
    
}
