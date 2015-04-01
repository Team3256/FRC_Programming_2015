package org.usfirst.frc.team3256.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class Elevator {
	//private double slope = 
	//private double yint = 
	private int slope = 995;
	private int yInt=-26;
	private int lC = 0;
	public Victor winch;
	public Victor winch2;
	public Encoder elevatorEncoder;
	public Elevator(int winchMotor, int winchMotor2, int elevatorEncoder1, int elevatorEncoder2){
		this.winch = new Victor(winchMotor);
		this.winch2 = new Victor(winchMotor2);
		this.elevatorEncoder= new Encoder(elevatorEncoder1, elevatorEncoder2);
		this.elevatorEncoder.reset();
	}
	public Encoder getEncoder(){
		return this.elevatorEncoder;
	}
	
	public void moveElevator(double speed, boolean isPressed, int loopCounter){
		
		if(speed<0.2 && speed >-0.2){
			speed =0.0;
		}
		System.out.println(elevatorEncoder.get());
		if(isPressed){
			winch.set(speed);
			winch2.set(-speed);
		}else{
			if(speed < 0.0){
				speed = Math.abs(speed);
			}
			winch.set(-speed);
			winch2.set(speed);
		}
	}
	public double getTicks(double feet){
		double y= slope*feet;
		return y+= yInt;
	}
	public boolean setElevatorFeet(boolean up, boolean down, double speed, double joySpeed){
		double distance = getTicks(1.0);
		boolean isPressed= up || down;
		if(isPressed&&joySpeed>-0.2 && joySpeed<0.2){
			if(up){
				if(Math.abs(elevatorEncoder.get())<distance){
					winch.set(speed);
					winch2.set(-speed);
					System.out.println("hello");
					return true;
				}else{
					winch.set(0.0);
					winch2.set(0.0);
					return false;
				}
			}else if(down){
				if(Math.abs(elevatorEncoder.get())<distance){
					winch.set(-speed);
					winch2.set(speed);
					System.out.println("hola");
					return true;
				}else{
					winch.set(0.0);
					winch2.set(0.0);
					return false;
				}
			}else{
				return false;
			}
		}else{
			winch.set(0.0);
			winch2.set(0.0);
			//moveElevator(joySpeed, false);
			elevatorEncoder.reset();
			return false;
		}
	}
}
