package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANJaguar.JaguarControlMode;
import edu.wpi.first.wpilibj.CANJaguar.LimitMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
    
    private final CANJaguar motor;
    
    public Arm() {
        motor = new CANJaguar(RobotMap.ARM_MOTOR.value);
        motor.disableControl();
        motor.configEncoderCodesPerRev(497);
        motor.configMaxOutputVoltage(12);
        motor.configLimitMode(LimitMode.SwitchInputsOnly);
        motor.setControlMode(JaguarControlMode.Position.getValue());
        motor.setPositionMode(CANJaguar.kQuadEncoder, 497, 0.0, 0.0, 0.0);
        motor.set(0.0);
        motor.enableControl();
    }
    
    public double getArmDegrees() {
        return motor.getPosition() * 360.0;
    }
    
    public void setPID(double P, double I, double D) {
        motor.setPID(P, I, D);
    }
    
    public void setArmDegrees(double angle, double P, double I, double D) {
        motor.setPID(P, I, D);
        motor.set(angle / 360.0);
    }
    
    @Override
    protected void initDefaultCommand() {}
    
    public void SetControlMode(int mode){
    	motor.setControlMode(mode);	
    }
    public void set(int value){
    	motor.set(value);
    }
    public boolean getForwardLimit(){
    	return motor.getForwardLimitOK();
    }
    
    public boolean getBackLimit(){
    	return motor.getReverseLimitOK();
    }
}