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
import org.usfirst.frc3588.Steamworks.Robot;
import org.usfirst.frc3588.Steamworks.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnOld extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_turnAngle;
    private double m_turnTime;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    
    static private double xAxis = 0.0;
	static private double yAxis = 0.0;
	static private double stop = 0.0;
	static private double twist = 0.3;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public TurnOld(double turnAngle, double turnTime) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_turnAngle = turnAngle;
        m_turnTime = turnTime;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	RobotMap.chassisGyro.reset();
    	RobotMap.chassisRobotDrive.setMaxOutput(1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	System.out.println(RobotMap.chassisGyro.getAngle());
        RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(xAxis, yAxis, m_turnAngle/Math.abs(m_turnAngle)*twist, stop);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
    	return (Math.abs(RobotMap.chassisGyro.getAngle()) > Math.abs(m_turnAngle));
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    	RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(stop, stop, stop, stop);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    }
}