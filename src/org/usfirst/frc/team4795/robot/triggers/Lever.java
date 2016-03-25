package org.usfirst.frc.team4795.robot.triggers;

import org.usfirst.frc.team4795.robot.OI;
import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class Lever extends Trigger  {
    
	private double lastPosition;
	private double currentPosition;
	
	public Lever() {
		lastPosition = Robot.oi.getManipulatorLever();
	}
	
    public boolean get() {
    	currentPosition = Robot.oi.getManipulatorLever();
    	if(Math.abs(currentPosition - lastPosition) > OI.LEVER_DEADZONE) {
    	    lastPosition = currentPosition;
    	    return true;
    	}
    	return false;
    }
    
    public void reset() {
    	lastPosition = currentPosition;
    }
    
}
