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
        double throttle = (1.0 - Robot.oi.RIGHTJOY.getThrottle()) / 2.0;
        if(Robot.oi.RIGHTJOY.getRawButton(4)) {
            Robot.arm.setRaw(throttle);
        } else if(Robot.oi.RIGHTJOY.getRawButton(6)) {
            Robot.arm.setRaw(-throttle);
        } else {
            Robot.arm.setRaw(0.0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.arm.setRaw(0.0);
    }

    @Override
    protected void interrupted() {
        end();
    }

}
