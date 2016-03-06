package org.usfirst.frc.team4795.robot;

public enum RobotMap {
    // Motor mappings
    LEFT_MOTOR_1(1),
    LEFT_MOTOR_2(2),
    RIGHT_MOTOR_1(3),
    RIGHT_MOTOR_2(4),
    ARM_MOTOR(5),
    // Joystick mappings
    LEFT_JOY(0),
    RIGHT_JOY(1),
    // Left joystick mappings
    BUTTON_INTAKE_IN(4),
    BUTTON_INTAKE_OUT(6),
    // Right joystick mappings
    BUTTON_ARM_UP(3),
    BUTTON_ARM_DOWN(5),
    BUTTON_THROTTLE_ARM(1);

    public final int value;

    RobotMap(int value) {
        this.value = value;
    }
}
