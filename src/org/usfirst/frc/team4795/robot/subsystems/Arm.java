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
        motor.changeControlMode(TalonControlMode.PercentVbus);
        //motor.changeControlMode(TalonControlMode.Position);
        //motor.setPID(0.0, 0.0, 0.0);
        motor.enableBrakeMode(true);
        motor.setVoltageRampRate(12.0);
        motor.enableControl();
    }
    
    public double getArmDegrees() {
        return motor.getPosition() * 360.0;
    }
    
    public void setPID(double P, double I, double D) {
        motor.setPID(P, I, D);
    }
    
    /*
     * Optimal PID Values
     * P = 0.500
     * I = 0.005
     * D = 0.100
     * Position Values
     * Full Back = 0.0
     * 90 Degrees ~ -0.634
     * 180 Degrees ~ -1.264
     * Floor ~ -1.528 or -pi/2
     */
    public void startSpeedMode() {
        motor.disableControl();
        motor.changeControlMode(TalonControlMode.Speed);
        motor.enableControl();
    }
    
    public void startPositionMode() {
        motor.disableControl();
        motor.changeControlMode(TalonControlMode.Position);
        motor.enableControl();
    }
    
    public void startPercentMode() {
        motor.disableControl();
        motor.changeControlMode(TalonControlMode.PercentVbus);
        motor.setVoltageRampRate(12.0);
        motor.enableControl();
    }
    
    public void setClosedLoopRampRate(double rampRate) {
        motor.setVoltageRampRate(rampRate);
    }
    
    public void resetEncPosition() {
        motor.setEncPosition(0);
    }
    
    public double getPosition() {
        return motor.getPosition();
    }
    
    public void setArmDegrees(double angle, double P, double I, double D) {
        startPositionMode();
        motor.setPID(P, I, D);
        //motor.set(angle / 360.0);
        motor.set(angle);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new HoldArm());
    }
    
    public void setControlMode(int mode){
    	motor.setControlMode(mode);	
    }
    public void setRaw(double value) {
    	motor.set(value);
    }
    public boolean getForwardLimit(){
    	return motor.isFwdLimitSwitchClosed();
    }
    
    public boolean getBackLimit(){
    	return motor.isRevLimitSwitchClosed();
    }
    
}
