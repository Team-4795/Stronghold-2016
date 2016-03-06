package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;
import org.usfirst.frc.team4795.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class HoldArm extends Command {
    
    public HoldArm() {
        requires(Robot.arm);
    }

    @Override
    protected void initialize() {
        Robot.arm.changeControlMode(TalonControlMode.Speed);
        Robot.arm.setPID(Arm.SPEED_P, Arm.SPEED_I, Arm.SPEED_D);
        // setting the speed to zero disables the control entirely for some reason
        Robot.arm.setRaw(0.0001);
    }

    @Override
    protected void execute() {}

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
