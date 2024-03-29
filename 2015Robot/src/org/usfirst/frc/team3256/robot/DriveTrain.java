package org.usfirst.frc.team3256.robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Gyro;
/**
 * Drive Drive Drive
 * 
 * @param VcRobotics
 */
public class DriveTrain {
	
	//set stuff
	private Victor leftFront, leftRear;
	private Victor rightFront, rightRear;
	private DoubleSolenoid shifter;
	private Encoder rEnc, lEnc;
	/**
	 * Creates a DriveTrain object
	 * 
	 * @param lf, lr, rf, rr, shifter1, shifter2
	 */ 
	public DriveTrain(int lf, int lr, int rf, int rr,int rEncP1,
			int rEncP2, int lEncP1, int lEncP2, int shifter1, int shifter2) {
		leftFront = new Victor(lf);
		leftRear = new Victor(lr);
		rightFront = new Victor(rf);
		rightRear = new Victor(rr);
		shifter = new DoubleSolenoid(shifter1, shifter2);
		rEnc = new Encoder(rEncP1, rEncP2);
		lEnc = new Encoder(lEncP1, lEncP2);
		rEnc.reset();
		lEnc.reset();

	}
	//public DriveTrain(){}
	
	public Encoder getLeftEncoder(){
		return lEnc;
	}
	public Encoder getRightEncoder(){
		return rEnc;
	}
	
	public DoubleSolenoid getShifter(){
		return shifter;
	}
	
	
	/**
	 * Set the left side speed
	 * 
	 * @param speed
	 */ 
	public void setLeftSpeed(double speed){
		speed = -speed;
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
