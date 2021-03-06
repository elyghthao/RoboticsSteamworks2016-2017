// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3588.Steamworks.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3588.Steamworks.Robot;
import org.usfirst.frc3588.Steamworks.RobotMap;

/**
 *
 */
public class ArmsOpen extends Command {
	private static double OFF = 0.0;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ArmsOpen() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int leftCount = Math.abs(RobotMap.climbingLeftRopeEncoder.get());
		int rightCount = Math.abs(RobotMap.climbingRightRopeEncoder.get());
		System.out.println("leftCount = " + leftCount);
		System.out.println("rightCount = " + rightCount);
		
    	RobotMap.climbingLeftSweeper.set(0.5);
    	RobotMap.climbingRightSweeper.set(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.climbingLeftSweeper.set(OFF);
    	RobotMap.climbingRightSweeper.set(OFF);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
