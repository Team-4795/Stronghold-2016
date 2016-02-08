package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {

    private final double distance;
    private final double F;
    private final double P;
    private final double I;
    private final double D;

    public DriveForward(double distance, double F, double P, double I, double D) {
        requires(Robot.drivetrain);
        this.distance = distance;
        this.F = F;
        this.P = P;
        this.I = I;
        this.D = D;
    }

    protected void initialize() {
        Robot.drivetrain.drive(distance, F, P, I, D);
    }

    protected void execute() {}

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
