package org.usfirst.frc.team1165.util.states;

public enum LinearLiftState
{
	IDLE(0), INTAKE(0), SWITCH(100), SCALE_DOWN(200), SCALE_UP(300);

	private int value;

	LinearLiftState(int value)
	{
		this.value = value;
	}

	public int get()
	{
		return value;
	}
}
