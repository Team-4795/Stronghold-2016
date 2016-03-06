package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualArm extends Command {
    
    public ManualArm() {
        requires(Robot.arm);
    }
    
    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        double throttle = (1.0 - Robot.oi.RIGHT_JOY.getThrottle()) / 2.0;
        Robot.arm.setPosRaw(throttle*-1.528, 0.500, 0.002, 0.100);
    }

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
