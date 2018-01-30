
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

//	private Solenoid solenoidArmExtend;
//	private Solenoid solenoidArmRetract;

//	private Solenoid solenoidKickerExtend;
//	private Solenoid solenoidKickerRetract;

	public Pneumatics()
	{
		arms = new DoubleSolenoid(1, RobotMap.SOLENOID_ARM_EXTEND_PORT, RobotMap.SOLENOID_ARM_RETRACT_PORT);
		kicker = new DoubleSolenoid(1, RobotMap.SOLENOID_KICKER_EXTEND_PORT, RobotMap.SOLENOID_KICKER_RETRACT_PORT);

//		solenoidArmExtend = new Solenoid(RobotMap.PCM_1, RobotMap.SOLENOID_ARM_EXTEND_PORT);
//		solenoidArmRetract = new Solenoid(RobotMap.PCM_1, RobotMap.SOLENOID_ARM_RETRACT_PORT);

//		solenoidKickerExtend = new Solenoid(RobotMap.PCM_1, RobotMap.SOLENOID_KICKER_EXTEND_PORT);
//		solenoidKickerRetract = new Solenoid(RobotMap.PCM_1, RobotMap.SOLENOID_KICKER_RETRACT_PORT);
	}
	
    public void initDefaultCommand() {
//    	 Set the default command for a subsystem here.
//        setDefaultCommand(new ExampleCommand());
    }
    
    public void closeArms()
    {
    	arms.set(Value.kForward);
//    	solenoidArmRetract.set(false);
//    	solenoidArmExtend.set(true);
    }
    
    public void openArms()
    {
    	arms.set(Value.kReverse);
//    	solenoidArmExtend.set(false);
//    	solenoidArmRetract.set(true);
    }
    
    public void extendKicker()
    {
    	kicker.set(Value.kForward);
//    	solenoidKickerRetract.set(false);
//    	solenoidKickerExtend.set(true);
    }
    
    public void retractKicker()
    {
    	kicker.set(Value.kReverse);
//    	solenoidKickerRetract.set(false);
//    	solenoidKickerExtend.set(true);
    }
    
    public void extendClimber()
    {
    	arms.set(Value.kForward);
    	kicker.set(Value.kReverse);
    }
    
    public void retractClimber()
    {
    	arms.set(Value.kReverse);
    	kicker.set(Value.kForward);
    }
    
    public void report()
    {
    	SmartDashboard.putString("Arms Status", arms.get().toString());
    	SmartDashboard.putString("Kicker Status", kicker.get().toString());
//    	SmartDashboard.putBoolean("Arm Extend", solenoidArmExtend.get());
//    	SmartDashboard.putBoolean("Arm Retract", solenoidArmRetract.get());
//    	SmartDashboard.putBoolean("Kicker Extend", solenoidKickerExtend.get());
//    	SmartDashboard.putBoolean("Kicker Retract", solenoidKickerRetract.get());
    }
}

