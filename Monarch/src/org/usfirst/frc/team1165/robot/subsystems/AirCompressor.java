
package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AirCompressor extends Subsystem
{
	private Compressor compressor = new Compressor(RobotMap.PCM_1);

	@Override
    public void initDefaultCommand() {
    }
    
    public void start()
    {
    	compressor.start();
    }
    
    public void stop()
    {
    	compressor.stop();
    }
    
    public void report()
    {
    	SmartDashboard.putBoolean("Compressor On", compressor.enabled());
    	SmartDashboard.putNumber("Compressor Current", compressor.getCompressorCurrent());
    }
}

