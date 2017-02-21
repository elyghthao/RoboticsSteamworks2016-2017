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

import org.usfirst.frc3588.Steamworks.GripPipelinePeg;
import org.usfirst.frc3588.Steamworks.Robot;
import org.usfirst.frc3588.Steamworks.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class ClimbingCommand extends Command {

	private boolean contoursFound;
	private VisionThread visionThread;
	private final Object imgLock = new Object();
	private boolean slowSpeed = true;
	private static final double SLOW_SPEED = 0.5;
	private static final double FAST_SPEED = 1.0;
	private static final double STOP = 0.0;
	private static final double TRIGGER_POINT = 10;
	private static final double CONTINUE_CLIMBING = 1.5;
	private boolean done = false;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public ClimbingCommand() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.climbing);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		/*contoursFound = false;
		visionThread = new VisionThread(Robot.cam0, new GripPipelinePeg(), pipeline -> {
			synchronized (imgLock) {
				System.out.println(pipeline.filterContoursOutput().isEmpty());
				contoursFound = pipeline.filterContoursOutput().isEmpty();

			}
		});
		visionThread.start();*/
		RobotMap.climbingMotor.set(SLOW_SPEED);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		// visionThread = new VisionThread(Robot.cam0, new GripPipeline(),
		// pipeline -> {
		// synchronized (imgLock) {
		// System.out.println(pipeline.filterContoursOutput().isEmpty());
		// contoursFound = pipeline.filterContoursOutput().isEmpty();
		//
		// }
		// });
		// if (slowSpeed == true) {
		// RobotMap.climbingMotor.set(SLOW_SPEED);
		// } else {
		// RobotMap.climbingMotor.set(FAST_SPEED);
		// }
		if (Robot.oi.turboClimb1.get() || Robot.oi.turboClimb2.get()) {
			if (slowSpeed == true) {
				RobotMap.climbingMotor.set(FAST_SPEED);
				slowSpeed = false;

			} else {
				RobotMap.climbingMotor.set(SLOW_SPEED);
				slowSpeed = true;
			}
			Timer.delay(1.0);
		}
		if (RobotMap.climbingTouchpadSensor.getAverageValue() <= TRIGGER_POINT) {
			RobotMap.climbingMotor.set(FAST_SPEED);
			Timer.delay(CONTINUE_CLIMBING);
			done = true;
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return done;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		RobotMap.climbingMotor.set(STOP);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
