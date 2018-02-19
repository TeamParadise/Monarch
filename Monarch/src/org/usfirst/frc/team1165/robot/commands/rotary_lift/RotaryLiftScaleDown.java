
package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import static org.usfirst.frc.team1165.util.RotaryLiftPosition.SCALE_DOWN;

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
