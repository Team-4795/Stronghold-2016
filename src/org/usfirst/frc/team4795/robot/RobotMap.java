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
    MANIPULATOR(2),
    // Left joystick mappings

    // Right joystick mappings
    PRIMARY_ARM_UP(3),
    PRIMARY_ARM_DOWN(5),
    BUTTON_THROTTLE_ARM(1),
    
    SECONDARY_ARM_DOWN(1),
    SECONDARY_ARM_UP(2),
    SECONDARY_INTAKE_IN(9),
    SECONDARY_INTAKE_OUT(10),
    
    PRIMARY(1),
    SECONDARY(2);
    

    public final int value;

    RobotMap(int value) {
        this.value = value;
    }
}
