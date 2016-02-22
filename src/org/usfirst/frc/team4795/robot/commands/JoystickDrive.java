package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class JoystickDrive extends Command {

    public JoystickDrive() {
        requires(Robot.drivetrain);
    }

    @Override
    protected void initialize() {
        Robot.drivetrain.changeControlMode(TalonControlMode.PercentVbus);
    }

    @Override
    protected void execute() {
        double leftDrive = Robot.oi.DRIVER_RIGHTJOY.getX() - Robot.oi.DRIVER_RIGHTJOY.getY();
        leftDrive = Math.max(leftDrive, -1.0);
        leftDrive = Math.min(leftDrive, 1.0);
        double rightDrive = (-Robot.oi.DRIVER_RIGHTJOY.getX()) - Robot.oi.DRIVER_RIGHTJOY.getY();
        rightDrive = Math.max(rightDrive, -1.0);
        rightDrive = Math.min(rightDrive, 1.0);
        double throttle = (1.0 - Robot.oi.DRIVER_LEFTJOY.getThrottle()) / 2.0;
        Robot.drivetrain.setRaw(leftDrive * throttle, rightDrive * throttle);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.drivetrain.drive(0.0, 0.0);
    }

    @Override
    protected void interrupted() {
        end();
    }

}
