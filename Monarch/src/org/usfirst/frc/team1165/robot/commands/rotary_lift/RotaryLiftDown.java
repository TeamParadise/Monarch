
package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import static org.usfirst.frc.team1165.robot.subsystems.RotaryLift.RotaryLiftPosition.DOWN;

/**
 *
 */
public class RotaryLiftDown extends RotaryLiftCommand
{
	protected void initialize()
	{
		initialize(DOWN);
	}
}
