package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.OI;
import org.usfirst.frc.team4795.robot.RobotMap;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class SecondaryArmDown extends Trigger {
    
	private OI oi;
	
	public SecondaryArmDown(OI operatorInterface) {
		oi = operatorInterface;
	}
	
    public boolean get() {
        return oi.getCurrentDriver() == RobotMap.SECONDARY && oi.MANIPULATOR.getRawButton(RobotMap.SECONDARY_ARM_DOWN.value);
    }
}
