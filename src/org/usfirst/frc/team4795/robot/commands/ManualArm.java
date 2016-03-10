package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;
import org.usfirst.frc.team4795.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManualArm extends Command {
    
    /*
     * Optimal Constants
     * P = 1.75
     * I = 0.0005
     * D = 20
     */
    public ManualArm() {
        requires(Robot.arm);
    }
    
    @Override
    protected void initialize() {
        Robot.arm.setRampRate(54);
    }

    @Override
    protected void execute() {
        double throttle = (1.0 - Robot.oi.RIGHT_JOY.getThrottle()) / 2.0;
        Robot.arm.setPosRaw(throttle*Arm.POS_RAW_FLOOR, Robot.arm.POS_P,
        												Robot.arm.POS_I,
        												Robot.arm.POS_D);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.arm.setRampRate(24);
    }

    @Override
    protected void interrupted() {
        end();
    }

}
