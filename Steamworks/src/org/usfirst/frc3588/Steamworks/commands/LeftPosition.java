package org.usfirst.frc3588.Steamworks.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPosition extends CommandGroup {

	public LeftPosition () {
        addSequential(new DriveStraight(2.0));
        addSequential(new Turn(18.3, 0));
        addSequential(new DrivePegCommand());
	}
}
