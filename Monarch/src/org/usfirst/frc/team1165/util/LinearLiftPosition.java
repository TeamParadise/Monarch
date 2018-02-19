package org.usfirst.frc.team1165.util;

public enum LinearLiftPosition
{
	IDLE(0), INTAKE(0), SWITCH(100), SCALE_DOWN(200), SCALE_UP(300);

	private int value;

	LinearLiftPosition(int value)
	{
		this.value = value;
	}

	public int get()
	{
		return value;
	}
}
