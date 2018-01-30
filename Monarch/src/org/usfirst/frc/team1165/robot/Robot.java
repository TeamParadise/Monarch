
package org.usfirst.frc.team1165.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team1165.robot.subsystems.AirCompressor;
import org.usfirst.frc.team1165.robot.subsystems.Pneumatics;
import org.usfirst.frc.team1165.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
	public static Pneumatics pneumatics;
	public static AirCompressor airCompressor;
	public static Shooter shooter;

	public static OI oi;

//    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
    	pneumatics = new Pneumatics();
    	airCompressor = new AirCompressor();
    	shooter = new Shooter();
    	
		oi = new OI();
        // instantiate the command used for the autonomous period
//        autonomousCommand = new ExtendPistons();
    }

    public void robotPeriodic()
    {
    	pneumatics.report();
    	airCompressor.report();
    	shooter.report();

    	oi.report();
    }
    
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
//        if (autonomousCommand != null)
//        	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
//        if (autonomousCommand != null)
//        	autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	oi.report();
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
//        LiveWindow.run();
    }
}
