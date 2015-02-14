package org.usfirst.frc.team3256.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * TeleopDrive
 * 
 * @author VcRobotics 
 */
public class TeleopDrive {
	
	/**
	 * Constructs a TeleopDrive object
	 */ 
	private DriveTrain drive;
	private DoubleSolenoid shifter;
	public TeleopDrive(DriveTrain drive) {
		//super(lf, lr, rf, rr, shifter1, shifter2);
		// TODO Auto-generated constructor stub]
		this.drive = drive;
		shifter = drive.getShifter();
		
	}
	
	/**
	 * Does some skimming. Takes off excess speed and dishes it off to the other side.
	 * 
	 * @param speed
	 */ 
	private double skim(double speed){
		double gain = 0.5;
		if (speed > 1.0) {
		    return -((speed - 1.0) * gain);
		}else if (speed < -1.0) {
		    return -((speed + 1.0) * gain);
		}else {
			return 0.0;
		}
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
	 * arcadeDrive.
	 * 
	 * @param throttle, turn
	 */ 
	public void arcadeDrive(double throttle, double turn) {
		//throttle = -throttle;
		if(turn<0.05 && turn>-0.05){
			turn =0.0;
		}else if(throttle<0.05 && throttle>-0.05){
			throttle=0.0;
		}
		double leftSpeed, rightSpeed, skimmedLeftSpeed, skimmedRightSpeed;
		leftSpeed=throttle + turn;
		rightSpeed=throttle - turn;
		
		skimmedLeftSpeed = leftSpeed + skim(leftSpeed);
		skimmedRightSpeed = rightSpeed + skim(rightSpeed);
		
		drive.setLeftSpeed(skimmedLeftSpeed);
		drive.setRightSpeed(skimmedRightSpeed);
	}
	
	/**
	 * TankDrive.
	 * 
	 * @param leftY, rightY
	 */
	public void tankDrive(double leftY, double rightY ){
		drive.setLeftSpeed(leftY);
		drive.setRightSpeed(rightY);
	}
	
}
