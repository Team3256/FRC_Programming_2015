package org.usfirst.frc.team3256.robot;


public class TeleopDrive extends DriveTrain{

	public TeleopDrive(int lf, int lr, int rf, int rr, int shifter1,
			int shifter2) {
		super(lf, lr, rf, rr, shifter1, shifter2);
		// TODO Auto-generated constructor stub
	}
	
	public double skim(double speed){
		double gain = 0.5;
		if (speed > 1.0) {
		    return -((speed - 1.0) * gain);
		}else if (speed < -1.0) {
		    return -((speed + 1.0) * gain);
		}else {
			return 0.0;
		}
	}
	public void arcadeDrive(double throttle, double turn) {
		throttle = -throttle;
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
		
		super.setLeftSpeed(skimmedLeftSpeed);
		super.setRightSpeed(-skimmedRightSpeed);
	}
	
	public void tankDrive(double leftY, double rightY ){
		super.setLeftSpeed(leftY);
		super.setRightSpeed(rightY);
	}
	
}
