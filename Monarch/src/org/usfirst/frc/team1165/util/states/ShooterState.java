package org.usfirst.frc.team1165.util.states;

public enum ShooterState
{
	IDLE(0, 0), INTAKE(1, 1), EJECT(-1, -1), TWIST_LEFT(-1, 1), TWIST_RIGHT(1, -1);

	private int mRightValue, mLeftValue;

	ShooterState(int rightValue, int leftValue)
	{
		this.mRightValue = rightValue;
		this.mLeftValue = leftValue;
	}

	public int getRight()
	{
		return mRightValue;
	}

	public int getLeft()
	{
		return mLeftValue;
	}
}