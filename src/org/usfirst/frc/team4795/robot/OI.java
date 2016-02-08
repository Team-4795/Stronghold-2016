package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.JoystickDrive;
import org.usfirst.frc.team4795.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

    public final Joystick LEFTJOY = new Joystick(0);
    public final Joystick RIGHTJOY = new Joystick(1);

    public OI() {
        new JoystickButton(RIGHTJOY, 3).whenPressed(new TankDrive());
        new JoystickButton(LEFTJOY, 4).whenPressed(new JoystickDrive());
    }

}
