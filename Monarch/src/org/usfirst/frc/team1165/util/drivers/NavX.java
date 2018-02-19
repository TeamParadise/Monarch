package org.usfirst.frc.team1165.util.drivers;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NavX
{
	private static final AHRS ahrs = new AHRS(SerialPort.Port.kMXP);

	public static double getAngle()
	{
		return ahrs.getAngle();
	}

	public static double getFusedHeading()
	{
		return ahrs.getFusedHeading();
	}

	public void reset()
	{
		ahrs.reset();
	}

	public void report()
	{
		SmartDashboard.putNumber("NavX Angle", ahrs.getAngle());
		SmartDashboard.putNumber("NavX Fused Heading", ahrs.getFusedHeading());
	}
}
