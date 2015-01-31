package org.usfirst.frc.team3256.robot;

import edu.wpi.first.wpilibj.Encoder;

/**
 * Autonomous Drive
 * 
 * @author VCRobotics (Newman)
 */
public class AutoDrive extends DriveTrain{
	
	//conversion units
	private double feetPerTick = 64.0/ 1045.0 / 14.0;
    private double anglePerTick = 1.68 / 90.0;
    	
    	//encoders
   	private Encoder rEnc, lEnc;
	
	/**
	 * Constructs an AutoDrive object
	 * 
	 * @param lf motor port, lr motor port, rf motor port, rr motor port, shifter1 port, shifter2 port, rEnc1 port, rEnc2 port, 
	 * 	lEnc1 port, lEnc2 port
	 */
	public AutoDrive(int lf, int lr, int rf, int rr, int shifter1, int shifter2, int rEncP1, int rEncP2, int lEncP1, int lEncP2) {
		super(lf, lr, rf, rr, shifter1, shifter2);
		// TODO Auto-generated constructor stub
		rEnc = new Encoder(rEncP1, rEncP2);
		lEnc = new Encoder(lEncP1, lEncP2);
		rEnc.setDistancePerPulse(feetPerTick);
		lEnc.setDistancePerPulse(feetPerTick);
	}
	
	/**
	 * Drives a set distance at a set speed
	 * 
	 * @param feet, speed
	 * 
	 */
	public void setFeet(double feet, double speed){
		if (feet < lEnc.getDistance()-.05 && feet < rEnc.getDistance()-.05) {
				super.setLeftSpeed(-speed);
				super.setRightSpeed(-speed);
        } else if (feet > rEnc.getDistance()+.05 && feet > lEnc.getDistance()+.05) {
        		super.setLeftSpeed(speed);
        		super.setRightSpeed(speed);
        } else{
            super.setLeftSpeed(0);
            super.setRightSpeed(0);
        }
	}
	
	/**
	 * Turn a set angle at a set speed
	 * 
	 * @param angle, speed
	 */
	public void setTurnAngle(double angle, double speed){
		if (angle * anglePerTick< lEnc.getDistance()-.05 && angle * anglePerTick< rEnc.getDistance()-.05) {
            //arcadeDrive(0, -0.8);
            super.setLeftSpeed(-speed);
            super.setRightSpeed(speed);
        } else if (angle * anglePerTick> lEnc.getDistance()-.05 && angle * anglePerTick> rEnc.getDistance()-.05) {
        	super.setLeftSpeed(speed);
            super.setRightSpeed(-speed);
        } else{
        	super.setLeftSpeed(0);
            super.setRightSpeed(0);
        }
            //arcadeDrive(0,0);
	}
}
