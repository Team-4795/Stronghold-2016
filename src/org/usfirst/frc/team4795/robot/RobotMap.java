package org.usfirst.frc.team4795.robot;

public enum RobotMap {
    LEFT_MOTOR_1(1),
    LEFT_MOTOR_2(2),
    RIGHT_MOTOR_1(3),
    RIGHT_MOTOR_2(4),
    ARM_MOTOR(5),
    BUTTON_INTAKE_IN(4),
    BUTTON_INTAKE_OUT(6),
    BUTTON_ARM_UP(3),
    BUTTON_ARM_DOWN(5);

    public final int value;

    RobotMap(int value) {
        this.value = value;
    }
}
