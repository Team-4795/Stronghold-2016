package org.usfirst.frc.team4795.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4795.robot.Robot;

/**
 * 
 *
 */
public class TankDrive extends Command {

	
    public TankDrive() {
        requires(Robot.drivetrain);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.startPercentMode();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(Robot.oi.getLeftJoy(), Robot.oi.getRightJoy());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
