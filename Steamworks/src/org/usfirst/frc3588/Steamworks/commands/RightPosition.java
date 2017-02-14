package org.usfirst.frc3588.Steamworks.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPosition extends CommandGroup {
	
	public RightPosition() {
        addSequential(new DriveStraight(3));
        addSequential(new Turn(-45.0, 1.0));
        addSequential(new DrivePegCommand());
	}
}
