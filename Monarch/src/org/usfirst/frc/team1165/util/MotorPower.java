package org.usfirst.frc.team1165.util;

public enum MotorPower
{
	IDLE(0), INTAKE(1), EJECT(-1);

	private int value;

	MotorPower(int value)
	{
		this.value = value;
	}

	public int get()
	{
		return value;
	}
}