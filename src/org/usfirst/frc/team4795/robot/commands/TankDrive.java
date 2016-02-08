package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {

    public TankDrive() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
        Robot.drivetrain.changeControlMode(TalonControlMode.PercentVbus);
    }

    protected void execute() {
        double throttle = (1.0 - Robot.oi.LEFTJOY.getThrottle()) / 2.0;
        Robot.drivetrain.setRaw(-Robot.oi.LEFTJOY.getY() * throttle,
                -Robot.oi.RIGHTJOY.getY() * throttle);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.drivetrain.drive(0.0, 0.0);
    }

    protected void interrupted() {
        end();
    }

}
