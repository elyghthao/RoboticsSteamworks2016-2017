package org.usfirst.frc3588.Steamworks.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPosition extends CommandGroup {

	public void LeftPosition() {
		addSequential(new DriveStraight(3));
		addSequential(new Turn(45.0, 1.0));
		addSequential(new DrivePegCommand());
	}
}
