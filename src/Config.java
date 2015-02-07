import java.util.Hashtable;

public class Config 
{
	public class ConfigException extends Exception
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ConfigException (String key)
		{
			super(key);
		}
	}
	
	public Hashtable <String, Object> variables;
	public Hashtable <String, Object> constants;
	
	public Config ()
	{
		if (constants == null || variables == null)
		{
			variables = new Hashtable <String, Object>();
			constants = new Hashtable <String, Object>();
		}
		initConfig();
	}
	
	private void addToConstants (String key, Object value)
	{
		if (constants.containsKey(key))
		{
			constants.replace(key, value);
		}
		else
		{
			constants.put(key, value);
		}
	}
	
	private void addToVariables (String key, Object value)
	{
		if (variables.containsKey(key))
		{
			variables.replace(key, value);
		}
		else
		{
			variables.put(key, value);
		}
	}
	
	private void initConfig ()
	{
		/*
		 * Human IO
		 */
			/*
			 * Constants
			 */
			addToConstants("JOYSTICK_LEFT", 0);
			addToConstants("JOYSTICK_RIGHT", 1);
			addToConstants("JOYSTICK_OPERATOR", 2);
		/*
		 * Chassis
		 */
			/*
			 * Constants
			 */
			addToConstants("CHASSIS_MOTOR_CONTROLLER_LEFT", 0);
			addToConstants("CHASSIS_MOTOR_CONTROLLER_RIGHT", 1);
			addToConstants("CHASSIS_MOTOR_CONTROLLER_CENTER", 2);
			
			addToConstants("CHASSIS_ENCODER_LEFT_A", 2);
			addToConstants("CHASSIS_ENCODER_LEFT_B", 3);
			
			addToConstants("CHASSIS_ENCODER_RIGHT_A", 4);
			addToConstants("CHASSIS_ENCODER_RIGHT_B", 5);
			
			addToConstants("CHASSIS_ENCODER_CENTER_A", 6);
			addToConstants("CHASSIS_ENCODER_CENTER_B", 7);
			
			addToConstants("CHASSIS_WIDTH", 0.5322); //in meters
			/*
			 * Variables
			 */

			 //Subsystem
			addToVariables("chassis_LeftScale", -1.0);
			addToVariables("chassis_RightScale", 1.0);
			addToVariables("chassis_CenterScale", 1.0);
			
			//TankDrive
			addToVariables("chassis_TankDrive_InvertX", false);
			addToVariables("chassis_TankDrive_InvertY", true);
			
			//RobotOrientedDrive
			addToVariables("chassis_RobotOrientedDrive_TurnScale", 1.0);
			
			//RobotOrientedNavigation
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KP_0", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KI_0", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KD_0", 0.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KP_0", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KI_0", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KD_0", 0.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KP_0", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KI_0", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KD_0", 0.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_AbsoluteTolerance", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_AbsoluteTolerance", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_AbsoluteTolerance", 0.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MinimumOutput", -1.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MaximumOutput", 1.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MinimumOutput", -1.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MaximumOutput", 1.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MinimumOutput", -1.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MaximumOutput", 1.0);
		/*
		 * Anschluss
		 */
			/*
			 * Constants
			 */
			addToConstants("ANSCHLUSS_MOTOR_CONTROLLER", 3);
			
			addToConstants("ANSCHLUSS_BUTTON_CLOSE", 1);
			addToConstants("ANSCHLUSS_BUTTON_OPEN", 0);
			
			/*
			 * Variables
			 */
			addToVariables("anschluss_CloseAnschluss_MotorSpeed", -0.5);
			addToVariables("anschluss_OpenAnschluss_MotorSpeed", 0.5);
		/*
		 * Roller Gripper
		 */
			
			/*
			 * Constants
			 */
				//Subsystem
					addToConstants("ROLLER_GRIPPER_IR_LEFT", 0);
					addToConstants("ROLLER_GRIPPER_IR_RIGHT", 1);
			/*
			 * Variables
			 */
				//Subsystem
					addToVariables("rollerGripper_LeftScale", -1.0);
					addToVariables("rollerGripper_RightScale", 1.0);
				//RollIn
					addToVariables("rollerGripper_RollIn_SpeedLeft", 0.5);
					addToVariables("rollerGripper_RollIn_SpeedRight", 0.5);
			
				//RollOut
					addToVariables("rollerGripper_RollOut_SpeedLeft", -0.5);
					addToVariables("rollerGripper_RollOut_SpeedRight", -0.5);
			
				//RollTurnClockwise
					addToVariables("rollerGripper_RollTurnClockwise_SpeedLeft", 0.5);
					addToVariables("rollerGripper_RollTurnClockwise_SpeedRight", -0.5);
			
				//RollTurnCounterClockwise
					addToVariables("rollerGripper_RollTurnCounterClockwise_SpeedLeft", 0.5);
					addToVariables("rollerGripper_RollTurnCounterClockwise_SpeedRight", -0.5);
					
		/*
		 * Stacker
		 */
			/*
			 * Constants
			 */
				//Subsystem
					addToConstants("STACKER_SWITCH_TOTE", 8);
					addToConstants("STACKER_SWITCH_GAMEPIECE", 9);
	}
}
