package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetArm extends Command {
    
    //private final double degrees;
    //private final double P;
    //private final double I;
    //private final double D;
    public static double P = 0.0;
    public static double I = 0.0;
    public static double D = 0.0;
    public static double rampRate = 0.0;

    public SetArm() {
        requires(Robot.arm);
        //this.degrees = degrees;
    }
    
    @Override
    protected void initialize() {
        //Robot.arm.setArmDegrees(degrees, P, I, D);
    }

    @Override
    protected void execute() {
        Robot.arm.setClosedLoopRampRate(rampRate);
        double throttle = (1.0 - Robot.oi.RIGHT_JOY.getThrottle()) / 2.0;
        Robot.arm.setArmDegrees(throttle*-1.528, P, I, D);
        SmartDashboard.putNumber("Throttle", throttle);
        SmartDashboard.putNumber("Setpoint", throttle*-1.528);
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
