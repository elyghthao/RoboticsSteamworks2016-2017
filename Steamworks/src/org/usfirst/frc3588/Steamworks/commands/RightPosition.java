package org.usfirst.frc3588.Steamworks.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPosition extends CommandGroup {

	public RightPosition() {
		addSequential(new DriveStraight(3, 1));
		addSequential(new Turn(-23.3, 1.0));
		addSequential(new DriveStraight(1.0, 0.7));
		addSequential(new DrivePegCommand());
		addSequential(new DriveStraight(0.75, 0.7));
		addSequential(new GearReleaseCommand());
		addSequential(new DriveStraight(1.0, 0.7));
		addSequential(new DriveStraight(1.5, -0.7));
		addSequential(new GearCloseCommand());
	}
}
