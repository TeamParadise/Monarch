
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
	private Compressor compressor;

	public AirCompressor()
	{
		compressor = new Compressor(RobotMap.PCM_1);
	}

	@Override
	public void initDefaultCommand()
	{
	}

	public void start()
	{
		compressor.start();
	}

	public void stop()
	{
		compressor.stop();
	}

	public boolean isEnabled()
	{
		return compressor.enabled();
	}

	public double getCurrent()
	{
		return compressor.getCompressorCurrent();
	}

	public void report()
	{
		SmartDashboard.putBoolean("Compressor On", isEnabled());
		SmartDashboard.putNumber("Compressor Current", getCurrent());
	}
}
