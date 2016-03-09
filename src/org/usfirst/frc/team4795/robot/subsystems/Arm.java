package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.HoldArm;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
    
    public static final int ENCODER_TICKS_PER_REV = 497;
    public static final double SPEED_P = 30.0;
    public static final double SPEED_I = 0.005;
    public static final double SPEED_D = 10;
    public static final double POS_P = 0.5;
    public static final double POS_I = 0.002;
    public static final double POS_D = 0.1;
    public static final double POS_RAW_90 = -0.634;
    public static final double POS_RAW_180 = -1.264;
    public static final double POS_RAW_FLOOR = -1.528;
    
    private final CANTalon motor;
    
    public Arm() {
        motor = new CANTalon(RobotMap.ARM_MOTOR.value);
        motor.disableControl();
        motor.configEncoderCodesPerRev(ENCODER_TICKS_PER_REV);
        motor.configMaxOutputVoltage(12);
        motor.ConfigFwdLimitSwitchNormallyOpen(true);
        motor.ConfigRevLimitSwitchNormallyOpen(true);
        motor.enableLimitSwitch(true, true);
        motor.enableBrakeMode(true);
        motor.setVoltageRampRate(24.0);
        motor.enableControl();
    }
    
    public void setPID(double P, double I, double D) {
        motor.setPID(P, I, D);
    }
    
    public void setRampRate(double rampRate) {
        motor.setVoltageRampRate(rampRate);
    }
    
    public void zeroPos() {
        motor.setEncPosition(0);
    }
    
    public double getPosRaw() {
        return motor.getPosition();
    }
    
    public double getPosDegrees() {
        return getPosRaw() * 360.0;
    }
    
    public void setPosDegrees(double angle, double P, double I, double D) {
        setPosRaw(angle / 360.0, P, I, D);
    }
    
    public void setPosRaw(double angle, double P, double I, double D) {
        changeControlMode(TalonControlMode.Position);
        motor.setPID(P, I, D);
        motor.set(angle);
    }
    
    public void changeControlMode(TalonControlMode mode) {
    	motor.changeControlMode(mode);
    }
    
    public void setRaw(double value) {
    	motor.set(value);
    }
    
    public boolean getForwardLimit() {
    	return motor.isFwdLimitSwitchClosed();
    }
    
    public boolean getReverseLimit() {
    	return motor.isRevLimitSwitchClosed();
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new HoldArm());
    }
    
}
