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
    /*
     * Arm position: -1 	-> 0
     * 				0.402	-> -1.283
     */
    protected void execute() {
        double throttle = (1.0 + Robot.oi.MANIPULATOR.getRawAxis(0)) * (-1.283)/(0.346+1.0);
        SmartDashboard.putNumber("Setpoint", throttle);
        Robot.arm.setPosRaw(throttle, Arm.POS_P, Arm.POS_I, Arm.POS_D);

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
