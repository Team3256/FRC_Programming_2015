package org.usfirst.frc.team3256.robot;

public class PID {
    
    private double kP;
    private double kI;
    private double kD;
    private double prevError;
    private double errorSum;
    
    public PID(double kP, double kI, double kD, double prevError, double errorSum){
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.prevError = 0;
        this.errorSum = 0;
    }
    public double calc(double setpoint, double current){
        double error = setpoint - current;
        double P = kP * error;
        errorSum += error;
        double I = kI * errorSum;
        double D = kD * (prevError - error);
        double PID = P + I + D;
        prevError = error;
        //System.out.println(PID);
        return PID;
    }
    public void resetError() {
        errorSum = 0.0;
        prevError = 0.0;
    }
            
    
    
}