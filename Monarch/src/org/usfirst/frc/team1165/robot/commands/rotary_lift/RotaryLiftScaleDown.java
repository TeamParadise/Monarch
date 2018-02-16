
package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import static org.usfirst.frc.team1165.robot.subsystems.RotaryLift.RotaryLiftPosition.SCALE_DOWN;

/**
 *
 */
public class RotaryLiftScaleDown extends RotaryLiftCommand
{
	protected void initialize()
	{
		initialize(SCALE_DOWN);
	}
}
