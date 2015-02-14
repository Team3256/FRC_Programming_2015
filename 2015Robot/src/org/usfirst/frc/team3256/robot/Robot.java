package org.usfirst.frc.team3256.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Gyro;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	DriveTrain drive;
	TeleopDrive robotDrive;
	AutoDrive robotAutoDrive;
	XboxController driver;
	Compressor compressor;
	Gyro gyro;
	//Encoder testEnc;
	//DriverStationLCD log;
	int autoLoopCounter;
	//AnalogPotentiometer pot;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	drive = new DriveTrain(Constants.LEFT_FRONT_PORT, Constants.LEFT_REAR_PORT, 
    			Constants.RIGHT_FRONT_PORT, Constants.RIGHT_REAR_PORT, Constants.RIGHT_ENCODER_PORT_1, 
    			Constants.RIGHT_ENCODER_PORT_2, Constants.LEFT_ENCODER_PORT_1,
    			Constants.LEFT_ENCODER_PORT_2, Constants.LEFT_SHIFTER_PORT, 
    			Constants.RIGHT_SHIFTER_PORT);
    	robotDrive= new TeleopDrive(drive);
    	robotAutoDrive = new AutoDrive(drive);
    	driver= new XboxController(0);
    	compressor = new Compressor(0);
    	gyro = new Gyro(0);
    	//System.out.println("hi");
    	//pot = new AnalogPotentiometer(0);
    	//testEnc = new Encoder(0,1);
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
    	//robotDrive.setShifterState(driver.getButtonRB());
    	gyro.reset();
        robotDrive.arcadeDrive(driver.getLeftY(), -driver.getRightX());
        
    	/*if(driver.getButtonLB()){
    		compressor.start();
    	}else if(driver.getButtonA()){
    		compressor.stop();
    	}*/
    	System.out.println(gyro.getAngle());
    	//System.out.println("Right Encoder: "+robotAutoDrive.getRightEnc());
    	//System.out.println("Left Encoder: "+robotAutoDrive.getLeftEnc());
    }
    	
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
