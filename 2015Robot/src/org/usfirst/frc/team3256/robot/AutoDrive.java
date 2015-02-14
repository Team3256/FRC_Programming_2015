package org.usfirst.frc.team3256.robot;

import edu.wpi.first.wpilibj.Encoder;

/**
 * Autonomous Drive
 * 
 * @author VCRobotics (Newman)
 */
public class AutoDrive {
	
	//conversion units
	private double feetPerTick = 64.0/ 1045.0 / 14.0;
    private double anglePerTick = 1.68 / 90.0;
    	
    	//encoders
    private Encoder rEnc, lEnc;
    private DriveTrain drive ;
	/**
	 * Constructs an AutoDrive object
	 * 
	 * @param lf motor port, lr motor port, rf motor port, rr motor port, shifter1 port, shifter2 port, rEnc1 port, rEnc2 port, 
	 * 	lEnc1 port, lEnc2 port
	 */
	public AutoDrive(DriveTrain drive) {
		//super(lf, lr, rf, rr, shifter1, shifter2);
		// TODO Auto-generated constructor stub
		this.drive = drive;
		rEnc= drive.getRightEncoder();
		lEnc=drive.getLeftEncoder();
	}
	
	public int getRightEnc(){
		
		return rEnc.get();
	}
	
	public int getLeftEnc(){
	
		return lEnc.get();
	}
	/**
	 * Drives a set distance at a set speed
	 * 
	 * @param feet, speed
	 * 
	 */
	public void setFeet(double feet, double speed){
		if (feet < lEnc.getDistance()-.05 && feet < rEnc.getDistance()-.05) {
			drive.setLeftSpeed(-speed);
			drive.setRightSpeed(-speed);
        } else if (feet > rEnc.getDistance()+.05 && feet > lEnc.getDistance()+.05) {
        	drive.setLeftSpeed(speed);
        	drive.setRightSpeed(speed);
        } else{
            drive.setLeftSpeed(0);
            drive.setRightSpeed(0);
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
            drive.setLeftSpeed(-speed);
            drive.setRightSpeed(speed);
        } else if (angle * anglePerTick> lEnc.getDistance()-.05 && angle * anglePerTick> rEnc.getDistance()-.05) {
        	drive.setLeftSpeed(speed);
            drive.setRightSpeed(-speed);
        } else{
        	drive.setLeftSpeed(0);
            drive.setRightSpeed(0);
        }
            //arcadeDrive(0,0);
	}
}