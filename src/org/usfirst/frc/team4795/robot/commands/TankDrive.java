package org.usfirst.frc.team4795.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4795.robot.Robot;

public class TankDrive extends Command {

    public TankDrive() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Robot.drivetrain.startPercentMode();
    }

    protected void execute() {
    	Robot.drivetrain.drive(Robot.oi.LEFTJOY.getY(), Robot.oi.RIGHTJOY.getY());
    }

    protected boolean isFinished() {return false;}

    protected void end() {}

    protected void interrupted() {}
    
}
