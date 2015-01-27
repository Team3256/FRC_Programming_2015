package org.usfirst.frc.team3256.robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class DriveTrain {
	
	private Talon leftFront, leftRear;
	private Victor rightFront, rightRear;
	private DoubleSolenoid shifter;
	
	public DriveTrain(int lf, int lr, int rf, int rr, int shifter1, int shifter2) {
		leftFront = new Talon(lf);
		leftRear = new Talon(lr);
		rightFront = new Victor(rf);
		rightRear = new Victor(rr);
		shifter = new DoubleSolenoid(shifter1, shifter2);
	}
	
	public void setShifterState(boolean state){
		if(state){
			shifter.set(DoubleSolenoid.Value.kForward);
		}else{
			shifter.set(DoubleSolenoid.Value.kReverse);
		}
	}
	
	public void setLeftSpeed(double speed){
		leftFront.set(speed);
		leftRear.set(speed);
	}
	
	public void setRightSpeed(double speed){
		rightFront.set(speed);
		rightRear.set(speed);
	}
}
