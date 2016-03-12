package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.OI;
import org.usfirst.frc.team4795.robot.RobotMap;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class PrimaryArmDown extends Trigger {
    
private OI oi;
	
	public PrimaryArmDown(OI operatorInterface) {
		oi = operatorInterface;
	}
	
    public boolean get() {
        return oi.getCurrentDriver() == RobotMap.PRIMARY && oi.RIGHT_JOY.getRawButton(RobotMap.PRIMARY_ARM_DOWN.value);
    }
}
