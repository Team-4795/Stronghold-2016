package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.OI;
import edu.wpi.first.wpilibj.buttons.Trigger;


/**
 *
 */
public class Lever extends Trigger {
    
	private double lastPosition, currentPosition;
	private OI oi;
	
	public Lever(OI operatorInterface) {
		oi = operatorInterface;
		lastPosition = oi.getLeverPosition();
		currentPosition = lastPosition;
	}
	
	
    public boolean get() {
    	currentPosition = oi.getLeverPosition();
    	boolean returnValue = currentPosition != lastPosition;
    	lastPosition = oi.getLeverPosition();
    	
    	return returnValue && !oi.RIGHT_JOY.getTrigger();
    	
    }
}
