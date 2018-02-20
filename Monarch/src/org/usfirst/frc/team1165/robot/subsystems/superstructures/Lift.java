//package org.usfirst.frc.team1165.robot.subsystems.superstructures;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.usfirst.frc.team1165.robot.commands.lift.LiftIdle;
//import org.usfirst.frc.team1165.robot.commands.lift.LiftIntake;
//import org.usfirst.frc.team1165.robot.commands.lift.LiftScaleDown;
//import org.usfirst.frc.team1165.robot.commands.lift.LiftScaleUp;
//import org.usfirst.frc.team1165.robot.commands.lift.LiftSwitch;
//import org.usfirst.frc.team1165.util.Stateful;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// * 
// * @author Kesav Kadalazhi
// *
// */
//public class Lift implements Stateful
//{
//	private static final Lift mInstance = new Lift();
//
//	public synchronized static Lift getInstance()
//	{
//		return mInstance;
//	}
//
//	protected Lift()
//	{
//	}
//
//	@Override
//	public List<Command> getCommands()
//	{
//		return Arrays.asList(new LiftIdle(), new LiftIntake(), new LiftScaleDown(), new LiftScaleUp(),
//				new LiftSwitch());
//	}
//
//	@Override
//	public void report()
//	{
//	}
//
//}
