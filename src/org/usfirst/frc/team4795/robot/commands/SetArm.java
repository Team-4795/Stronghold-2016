package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetArm extends Command {
    
    private final double degrees;
    private final double P;
    private final double I;
    private final double D;

    public SetArm(double degrees, double P, double I, double D) {
        requires(Robot.arm);
        this.degrees = degrees;
        this.P = P;
        this.I = I;
        this.D = D;
    }
    
    @Override
    protected void initialize() {
        Robot.arm.setArmDegrees(degrees, P, I, D);
    }

    @Override
    protected void execute() {}

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {
        end();
    }

}
