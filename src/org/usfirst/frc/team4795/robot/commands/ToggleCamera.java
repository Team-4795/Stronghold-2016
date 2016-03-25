package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.CameraSwitcher;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleCamera extends Command {
    
    private boolean toggled = false;

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        if(!toggled) {
            CameraSwitcher.toggle();
            toggled = true;
        }
    }

    @Override
    protected boolean isFinished() {
        return toggled;
    }

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {
        end();
    }

}
