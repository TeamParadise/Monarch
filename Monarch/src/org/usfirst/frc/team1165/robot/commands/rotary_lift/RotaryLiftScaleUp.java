
package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import static org.usfirst.frc.team1165.robot.subsystems.RotaryLift.RotaryLiftPosition.SCALE_UP;

/**
 *
 */
public class RotaryLiftScaleUp extends RotaryLiftCommand
{
	protected void initialize()
	{
		initialize(SCALE_UP);
	}
}
