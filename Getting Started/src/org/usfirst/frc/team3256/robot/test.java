package org.usfirst.frc.team3256.robot;

public class test {
	public static void main(String args[]){
		double turn = 1.0;
		double throttle = 0.0;
		double leftSpeed, rightSpeed, skimmedLeftSpeed, skimmedRightSpeed;
		//if(turn>=0.0){
			leftSpeed=throttle + turn;
			rightSpeed=throttle - turn;
		//}else{
			//leftSpeed=throttle - turn;
			//rightSpeed=throttle + turn;
		//}
		skimmedLeftSpeed = leftSpeed + skim(leftSpeed);
		skimmedRightSpeed = rightSpeed + skim(rightSpeed);
		System.out.println(skimmedLeftSpeed);
		System.out.println(skimmedRightSpeed);
	}
	public static double skim(double speed){
		double gain = 0.5;
		if (speed > 1.0) {
		    return -((speed - 1.0) * gain);
		}else if (speed < -1.0) {
		    return -((speed + 1.0) * gain);
		}else {
			return 0.0;
		}
	}
}
