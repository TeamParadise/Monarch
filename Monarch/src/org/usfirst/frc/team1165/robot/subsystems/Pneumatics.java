
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Pneumatics extends Subsystem
{
	private DoubleSolenoid arms;
	private DoubleSolenoid kicker;
	private DoubleSolenoid isolateKicker;
	
	public Pneumatics()
	{
		arms = new DoubleSolenoid(RobotMap.PCM_1, RobotMap.SOLENOID_ARM_EXTEND_PORT, RobotMap.SOLENOID_ARM_RETRACT_PORT);
		kicker = new DoubleSolenoid(RobotMap.PCM_1, RobotMap.SOLENOID_KICKER_EXTEND_PORT, RobotMap.SOLENOID_KICKER_RETRACT_PORT);
		isolateKicker = new DoubleSolenoid(RobotMap.PCM_1, RobotMap.SOLENOID_KICKER_AVAILABLE_PORT, RobotMap.SOLENOID_KICKER_ISOLATED_PORT);
	}
	
    public void initDefaultCommand() {
    }
    
    public void closeArms() {
    	arms.set(Value.kForward);
    }
    
    public void openArms() {
    	arms.set(Value.kReverse);
    }
    
    public void airToKicker() {
    	isolateKicker.set(Value.kForward);
    }
    
    public void isolateKicker() {
    	isolateKicker.set(Value.kReverse);
    }
    
    public void extendKicker() {
    	kicker.set(Value.kForward);
    }
    
    public void retractKicker() {
    	kicker.set(Value.kReverse);
    }
     
    public void extendClimber()
    {
    	arms.set(Value.kForward);
    	airToKicker();
    	kicker.set(Value.kReverse);
    }
    
    public void retractClimber()
    {
    	arms.set(Value.kReverse);
    	airToKicker();
    	kicker.set(Value.kForward);
    }
    
    public void report()
    {
    	SmartDashboard.putString("Arms", arms.get().toString());
    	SmartDashboard.putString("Big Kicker", kicker.get().toString());
    	SmartDashboard.putString("Little Kicker", isolateKicker.get().toString());
    }
}

