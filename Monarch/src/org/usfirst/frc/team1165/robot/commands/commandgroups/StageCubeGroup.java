package org.usfirst.frc.team1165.robot.commands.commandgroups;

import org.usfirst.frc.team1165.robot.commands.AirToKicker;
import org.usfirst.frc.team1165.robot.commands.ExtendKicker;
import org.usfirst.frc.team1165.robot.commands.IsolateKicker;
import org.usfirst.frc.team1165.robot.commands.RetractKicker;
import org.usfirst.frc.team1165.robot.commands.Shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StageCubeGroup extends CommandGroup
{
    public StageCubeGroup()
    {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new RetractKicker());
    	addSequential(new AirToKicker());
    	addSequential(new WaitCommand(.1));
    	// wait for .1 sec
    	addSequential(new IsolateKicker());
    	addSequential(new WaitCommand(.1));
    	addSequential(new ExtendKicker());
    }
}
