//package org.usfirst.frc.team1165.robot.commands.intake;
//
//import org.usfirst.frc.team1165.robot.commands.ClawCommand;
//import org.usfirst.frc.team1165.robot.commands.FrontShooterCommand;
//import org.usfirst.frc.team1165.robot.commands.RearShooterCommand;
//import org.usfirst.frc.team1165.util.states.ShooterState;
//
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.command.CommandGroup;
//
///**
// *
// */
//public class IntakeIdle extends CommandGroup
//{
//	public IntakeIdle()
//	{
//		addParallel(new ClawCommand(Value.kOff));
//		addParallel(new FrontShooterCommand(ShooterState.IDLE));
//		addParallel(new RearShooterCommand(ShooterState.IDLE));
//	}
//}
