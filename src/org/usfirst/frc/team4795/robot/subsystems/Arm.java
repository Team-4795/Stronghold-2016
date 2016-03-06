package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.HoldArm;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
    
    private final CANTalon motor;
    
    public Arm() {
        motor = new CANTalon(RobotMap.ARM_MOTOR.value);
        motor.disableControl();
        motor.configEncoderCodesPerRev(497);
        motor.configMaxOutputVoltage(12);
        motor.ConfigFwdLimitSwitchNormallyOpen(true);
        motor.ConfigRevLimitSwitchNormallyOpen(true);
        motor.enableLimitSwitch(true, true);
        motor.enableBrakeMode(true);
        motor.setVoltageRampRate(12.0);
        motor.enableControl();
    }
    
    public void setPID(double P, double I, double D) {
        motor.setPID(P, I, D);
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
    
    /*
     * Raw Position Values
     * Full Back   ~  0.000
     * 90 Degrees  ~ -0.634
     * 180 Degrees ~ -1.264
     * Floor       ~ -1.528
     */
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
    
    public boolean getBackLimit() {
    	return motor.isRevLimitSwitchClosed();
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new HoldArm());
    }
    
}
