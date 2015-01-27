package org.usfirst.frc.team3256.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	TeleopDrive robotDrive;
	XboxController driver;
	Compressor compressor;
	Encoder testEnc;
	//DriverStationLCD log;
	int autoLoopCounter;
	AnalogPotentiometer pot;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	robotDrive= new TeleopDrive(Constants.LEFT_FRONT_PORT, Constants.LEFT_REAR_PORT, 
    			Constants.RIGHT_FRONT_PORT, Constants.RIGHT_REAR_PORT, Constants.LEFT_SHIFTER_PORT, 
    			Constants.RIGHT_SHIFTER_PORT);
    	driver= new XboxController(0);
    	compressor = new Compressor(0);
    	pot = new AnalogPotentiometer(0);
    	testEnc = new Encoder(0,1);
    	//compressor.setClosedLoopControl(true);
    	//compressor.start();
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	autoLoopCounter = 0;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	/*if(autoLoopCounter < 100) //Check if we've completed 100 loops (approximately 2 seconds)
		{
			myRobot.drive(-0.5, 0.0); 	// drive forwards half speed
			autoLoopCounter++;
			} else {
			myRobot.drive(0.0, 0.0); 	// stop robot
		}*/
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    	//System.out.println("Hi");   
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	robotDrive.setShifterState(driver.getButtonRB());
        robotDrive.arcadeDrive(-driver.getLeftY(), driver.getRightX());
    	if(driver.getButtonLB()){
    		compressor.start();
    	}else if(driver.getButtonA()){
    		compressor.stop();
    	}
    	System.out.println(testEnc.get());
        //while(true){
    	//System.out.println("left joy= " + driver.getLeftY());
    	//System.out.println("right joy= " + driver.getRightX());
    	//}*/
    	/*double vPerDegree =360/0.099;
    	double vConstantOffset= 10.909;
    	double potV=pot.get();
    	if(potV <=0.002){
    		potV=0;
    	}
    	if(potV!=0){
    		System.out.println((potV*vPerDegree)+vConstantOffset);
    	}else{
    		System.out.println(0);
    	}*/
    }
    	
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
