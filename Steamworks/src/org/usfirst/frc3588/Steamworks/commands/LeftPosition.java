package org.usfirst.frc3588.Steamworks.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPosition extends CommandGroup {

	public LeftPosition() {
		addSequential((new DriveStraight( 3, 1)));
		addSequential((new Turn (26.3, 0)));
		addSequential(new DriveStraight(1.0, 0.7));
		//addSequential(new DrivePegCommand());
		addSequential(new DriveStraight(0.75, 0.7));
		addSequential(new GearReleaseCommand());
		addSequential(new DriveStraight(1.0, 0.7));
		addSequential(new DriveStraight(1.5, -0.7));
		addSequential(new GearCloseCommand());
	}
}
