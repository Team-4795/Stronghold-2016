package org.usfirst.frc.team4795.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ActiveIntake extends Subsystem {
    
    //private final VictorSP intake;
    private final Talon intake;
    private final DigitalInput limitSwitch;

    public ActiveIntake() {
        //intake = new VictorSP(0);
        intake = new Talon(0);
        limitSwitch = new DigitalInput(0);
    }

    public void spin(double speed) {
        speed = Math.max(speed, -1.0);
        speed = Math.min(speed, 1.0);
        intake.set(speed);
    }
    
    public boolean getLimit() {
        return limitSwitch.get();
    }
    
    @Override
    protected void initDefaultCommand() {}

}
