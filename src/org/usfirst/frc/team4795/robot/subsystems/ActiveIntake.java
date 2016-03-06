package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.commands.SpinIntake;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ActiveIntake extends Subsystem {
    
    private final VictorSP intake;
    private final DigitalInput limitSwitch;

    public ActiveIntake() {
        intake = new VictorSP(0);
        limitSwitch = new DigitalInput(0);
    }

    public void spin(double speed) {
        intake.set(speed);
    }
    
    public boolean getLimit() {
        return limitSwitch.get();
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new SpinIntake(0.0));
    }

}
