package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualIntake extends Command {
    
    public ManualIntake() {
        requires(Robot.intake);
    }
    
    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        if((!Robot.intake.getLimit()) && Robot.oi.ARM_GAMEPAD.getRawButton(3)) {
            Robot.intake.spin(0.2);
        } else if(Robot.oi.ARM_GAMEPAD.getRawButton(5)) {
            Robot.intake.spin(-0.2);
        } else {
            Robot.intake.spin(0.0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intake.spin(0.0);
    }

    @Override
    protected void interrupted() {
        end();
    }

}
