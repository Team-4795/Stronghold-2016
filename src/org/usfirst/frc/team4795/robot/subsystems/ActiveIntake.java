package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.commands.SpinIntake;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ActiveIntake extends Subsystem {
    
    private final VictorSP intake;

    public ActiveIntake() {
        intake = new VictorSP(0);
    }

    public void spin(double speed) {
        speed = Math.max(speed, -1.0);
        speed = Math.min(speed, 1.0);
        intake.set(speed);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new SpinIntake(0.0));
    }

}
