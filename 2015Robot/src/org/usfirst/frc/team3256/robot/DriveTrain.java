package org.usfirst.frc.team3256.robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

/**
 * Drive Drive Drive
 * 
 * @param VcRobotics
 */
public class DriveTrain {
	
	//set stuff
	private Talon leftFront, leftRear;
	private Victor rightFront, rightRear;
	private DoubleSolenoid shifter;
	
	/**
	 * Creates a DriveTrain object
	 * 
	 * @param lf, lr, rf, rr, shifter1, shifter2
	 */ 
	public DriveTrain(int lf, int lr, int rf, int rr, int shifter1, int shifter2) {
		leftFront = new Talon(lf);
		leftRear = new Talon(lr);
		rightFront = new Victor(rf);
		rightRear = new Victor(rr);
		shifter = new DoubleSolenoid(shifter1, shifter2);
	}
	
	/**
	 * Shifts the robot
	 * 
	 * @param state (true engaged)
	 */ 
	public void setShifterState(boolean state){
		if(state){
			shifter.set(DoubleSolenoid.Value.kForward);
		}else{
			shifter.set(DoubleSolenoid.Value.kReverse);
		}
	}
	
	/**
	 * Set the left side speed
	 * 
	 * @param speed
	 */ 
	public void setLeftSpeed(double speed){
		leftFront.set(speed);
		leftRear.set(speed);
	}
	
	/**
	 * Set the right side speed
	 * 
	 * @param speed
	 */ 
	public void setRightSpeed(double speed){
		rightFront.set(speed);
		rightRear.set(speed);
	}
}
