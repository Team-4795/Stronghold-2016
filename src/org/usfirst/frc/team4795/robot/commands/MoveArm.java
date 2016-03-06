package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command {
    
    private final double speed;
    
    public MoveArm(double speed) {
        requires(Robot.arm);
        this.speed = speed;
    }

    @Override
    protected void initialize() {
        Robot.arm.changeControlMode(TalonControlMode.PercentVbus);
    }

    @Override
    protected void execute() {
        // TODO make this command use speed control
        double throttle = (1.0 - Robot.oi.RIGHT_JOY.getThrottle()) / 2.0;
        Robot.arm.setRaw(speed * throttle);
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
