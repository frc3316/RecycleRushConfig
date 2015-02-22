import java.util.Hashtable;

public class Config 
{	
	public Hashtable <String, Object> variablesB;
	public Hashtable <String, Object> constantsB;
	
	public Hashtable <String, Object> variablesA;
	public Hashtable <String, Object> constantsA;
	
	public Config ()
	{
		variablesB = new Hashtable <String, Object>();
		constantsB = new Hashtable <String, Object>();
		
		variablesA = new Hashtable <String, Object>();
		constantsA = new Hashtable <String, Object>();
		
		initConfig();
	}
	
	private void addToConstantsA (String key, Object value)
	{
		if (constantsA.containsKey(key))
		{
			constantsA.replace(key, value);
		}
		else
		{
			constantsA.put(key, value);
		}
	}
	
	private void addToVariablesA (String key, Object value)
	{
		if (variablesA.containsKey(key))
		{
			variablesA.replace(key, value);
		}
		else
		{
			variablesA.put(key, value);
		}
	}
	
	private void addToConstantsB (String key, Object value)
	{
		if (constantsB.containsKey(key))
		{
			constantsB.replace(key, value);
		}
		else
		{
			constantsB.put(key, value);
		}
	}
	
	private void addToVariablesB (String key, Object value)
	{
		if (variablesB.containsKey(key))
		{
			variablesB.replace(key, value);
		}
		else
		{
			variablesB.put(key, value);
		}
	}
	
	private void addToConstants (String key, Object value)
	{
		addToConstantsA(key, value);
		addToConstantsB(key, value);
	}
	
	private void addToVariables (String key, Object value)
	{
		addToVariablesA(key, value);
		addToVariablesB(key, value);
	}
	
	/*
	 * NOTE: constants and variables that are common to both robot A and robot B should
	 * be added with addToConstants() or addToVariables()
	 * 
	 * Specify the which table to add the constant or variable to only if there is a
	 * difference between the two robots
	 */
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
			
			//subsystem
				/*
				 * Stacker
				 */
				addToConstants("BUTTON_MOVE_STACKER_TO_FLOOR", 1);
				addToConstants("BUTTON_MOVE_STACKER_TO_STEP", 2);
				addToConstants("BUTTON_MOVE_STACKER_TO_TOTE", 4);
				
				addToConstants("BUTTON_HOLD_CONTAINER", 10);
				addToConstants("BUTTON_RELEASE_CONTAINER", 9);
				
				addToConstants("BUTTON_OPEN_GRIPPER", 5);
				addToConstants("BUTTON_CLOSE_GRIPPER", 6);
				
				/*
				 * Roller-Gripper
				 */
				addToConstants("BUTTON_ROLL_IN", 180);
				addToConstants("BUTTON_ROLL_OUT", 0);
				addToConstants("BUTTON_ROLL_TURN_CLOCKWISE", 90);
				addToConstants("BUTTON_ROLL_TURN_COUNTER_CLOCKWISE", 270);
				
				/*
				 * Anschluss
				 */
				addToConstants("BUTTON_OPEN_ANSCHLUSS", 8);
				addToConstants("BUTTON_CLOSE_ANSCHLUSS", 7);
				
		/*
		 * Robot IO
		 */
			/*
			 * Motor Controllers
			 */
				addToConstants("CHASSIS_MOTOR_CONTROLLER_LEFT_1", 5);
				addToConstants("CHASSIS_MOTOR_CONTROLLER_LEFT_2", 6);
				
				addToConstants("CHASSIS_MOTOR_CONTROLLER_RIGHT_1", 1);
				addToConstants("CHASSIS_MOTOR_CONTROLLER_RIGHT_2", 2);
				
				addToConstants("CHASSIS_MOTOR_CONTROLLER_CENTER", 4);
				
				addToConstants("ANSCHLUSS_MOTOR_CONTROLLER", 8);
				
				addToConstants("ROLLER_GRIPPER_MOTOR_CONTROLLER_LEFT", 7);
				addToConstants("ROLLER_GRIPPER_MOTOR_CONTROLLER_RIGHT", 3);
				
		/*
		 * Chassis
		 */
			/*
			 * Constants
			 */
			
			
			addToConstants("CHASSIS_ENCODER_LEFT_A", 4);
			addToConstants("CHASSIS_ENCODER_LEFT_B", 5);
			
			addToConstants("CHASSIS_ENCODER_RIGHT_A", 2);
			addToConstants("CHASSIS_ENCODER_RIGHT_B", 3);
			
			addToConstants("CHASSIS_ENCODER_CENTER_A", 0);
			addToConstants("CHASSIS_ENCODER_CENTER_B", 1);
			
			/*
			 * Robot A
			 */
			addToConstantsA("CHASSIS_ENCODER_LEFT_DISTANCE_PER_PULSE", 0.0018702293765902);
			addToConstantsA("CHASSIS_ENCODER_RIGHT_DISTANCE_PER_PULSE", -0.0018702293765902);
			addToConstantsA("CHASSIS_ENCODER_CENTER_DISTANCE_PER_PULSE", 0.0099745566751476);
			
			/*
			 * Robot B
			 */
			addToConstantsB("CHASSIS_ENCODER_LEFT_DISTANCE_PER_PULSE", 0.0149618350127214);
			addToConstantsB("CHASSIS_ENCODER_RIGHT_DISTANCE_PER_PULSE", -0.0149618350127214);
			addToConstantsB("CHASSIS_ENCODER_CENTER_DISTANCE_PER_PULSE", 0.0099745566751476);
			
			
			addToConstants("CHASSIS_WIDTH", 0.5322); //in meters
			/*
			 * Variables
			 */

			 //Subsystem
			addToVariables("chassis_LeftScale", 1.0);
			addToVariables("chassis_RightScale", -1.0);
			addToVariables("chassis_CenterScale", 1.0);
			
			addToVariables("chassis_HeadingToSet", 0.0); // This is the heading that the SetHeadingSDB command sets to
														 // It is configurable in the SDB (it should appear in initSDB())
			//TankDrive
			addToVariables("chassis_TankDrive_InvertX", false);
			addToVariables("chassis_TankDrive_InvertY", true);
			
			addToVariables("chassis_TankDrive_LowPass", 0.0);
			//RobotOrientedDrive
			addToVariables("chassis_RobotOrientedDrive_TurnScale", 1.0);
			
			//RobotOrientedNavigation
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KP", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KI", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KD", 0.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KP", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KI", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KD", 0.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KP", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KI", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KD", 0.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_AbsoluteTolerance", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_AbsoluteTolerance", 0.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_AbsoluteTolerance", 0.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MinimumOutput", -1.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MaximumOutput", 1.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MinimumOutput", -1.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MaximumOutput", 1.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MinimumOutput", -1.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MaximumOutput", 1.0);
			
			//Dropoff Sequence
			addToVariables("chassis_DropoffSequence_BackwardsDistance", -0.5);
		/*
		 * Anschluss
		 */
			/*
			 * Constants
			 */
			addToConstants("ANSCHLUSS_DIGITAL_INPUT_CLOSED", 11);
			addToConstants("ANSCHLUSS_DIGITAL_INPUT_OPENED", 10);
			
			/*
			 * Variables
			 */
			addToVariables("anschluss_CloseAnschluss_MotorSpeed", -1.0);
			addToVariables("anschluss_OpenAnschluss_MotorSpeed", 1.0);
		/*
		 * Roller Gripper
		 */
			
			/*
			 * Constants
			 */
			addToConstants("ROLLER_GRIPPER_GAME_PIECE_IR", 1);
			addToConstants("ROLLER_GRIPPER_SWITCH_GAME_PIECE", 6);
			
			/*
			 * Variables
			 */
				//Subsystem
					addToVariables("rollerGripper_LeftScale", 1.0);
					addToVariables("rollerGripper_RightScale", -1.0);
					
					//TODO: re-determine distances
					/*
					 * Robot A
					 */
					addToVariablesA("rollerGripper_ToteDistanceMinimum", 0.32);
					addToVariablesA("rollerGripper_ToteDistanceMaximum", 0.365);
					
					addToVariablesA("rollerGripper_ContainerDistanceMinimum", 0.38);
					addToVariablesA("rollerGripper_ContainerDistanceMaximum", 0.42);
					
					addToVariablesA("rollerGripper_SomethingDistanceThreshold", 1.0);
					addToVariablesA("rollerGripper_UnsureDistanceThreshold", 1.7);
					
					/*
					 * Robot B
					 */
					addToVariablesB("rollerGripper_ToteDistanceMinimum", 0.32);
					addToVariablesB("rollerGripper_ToteDistanceMaximum", 0.365);
					
					addToVariablesB("rollerGripper_ContainerDistanceMinimum", 0.38);
					addToVariablesB("rollerGripper_ContainerDistanceMaximum", 0.42);
					
					addToVariablesB("rollerGripper_SomethingDistanceThreshold", 0.9);
					addToVariablesB("rollerGripper_UnsureDistanceThreshold", 1.4);
					
				//RollIn
					addToVariables("rollerGripper_RollIn_SpeedLeft", 1.0);
					addToVariables("rollerGripper_RollIn_SpeedRight", 1.0);
			
				//RollOut
					addToVariables("rollerGripper_RollOut_SpeedLeft", -1.0);
					addToVariables("rollerGripper_RollOut_SpeedRight", -1.0);
			
				//RollTurnClockwise
					addToVariables("rollerGripper_RollTurnClockwise_SpeedLeft", -1.0);
					addToVariables("rollerGripper_RollTurnClockwise_SpeedRight", 1.0);
			
				//RollTurnCounterClockwise
					addToVariables("rollerGripper_RollTurnCounterClockwise_SpeedLeft", 1.0);
					addToVariables("rollerGripper_RollTurnCounterClockwise_SpeedRight", -1.0);
					
				//RollJoystick
					addToVariables("rollerGripper_RollJoystick_ChannelX", 0);
					addToVariables("rollerGripper_RollJoystick_ChannelY", 1);
					
					addToVariables("rollerGripper_RollJoystick_InvertX", false);
					addToVariables("rollerGripper_RollJoystick_InvertY", false);
					
					addToVariables("rollerGripper_RollJoystick_LowPass", 0.15);
					
		/*
		 * Stacker
		 */
			/*
			 * Constants
			 */
				//Subsystem
					addToConstants("STACKER_SOLENOID_UPPER_FORWARD", 6);
					addToConstants("STACKER_SOLENOID_UPPER_REVERSE", 7);
					
					addToConstants("STACKER_SOLENOID_BOTTOM_FORWARD", 4);
					addToConstants("STACKER_SOLENOID_BOTTOM_REVERSE", 5);
					
					addToConstants("STACKER_SOLENOID_CONTAINER_FORWARD", 3);
					addToConstants("STACKER_SOLENOID_CONTAINER_REVERSE", 2);
					
					addToConstants("STACKER_SOLENOID_GRIPPER_FORWARD", 0);
					addToConstants("STACKER_SOLENOID_GRIPPER_REVERSE", 1);
					
					addToConstants("STACKER_IR", 0);
					

					addToConstants("SWITCH_RATCHET_LEFT", 7);
					addToConstants("SWITCH_RATCHET_RIGHT", 8);
			/*
			 * Variables
			 */
				//Subsystem
					
					//TODO: re-determine these values
					/*
					 * Robot A
					 */
					addToVariablesA("stacker_HeightFloorMinimum", 0.0);
					addToVariablesA("stacker_HeightFloorMaximum", 0.6);
					
					addToVariablesA("stacker_HeightStepMinimum", 2.0);
					addToVariablesA("stacker_HeightStepMaximum", 2.8);

					addToVariablesA("stacker_HeightToteMinimum", 5.0);
					addToVariablesA("stacker_HeightToteMaximum", 20.0);
					
					/*
					 * Robot B
					 */
					addToVariablesB("stacker_HeightFloorMinimum", 0.0);
					addToVariablesB("stacker_HeightFloorMaximum", 1.49);
					
					addToVariablesB("stacker_HeightStepMinimum", 1.49);
					addToVariablesB("stacker_HeightStepMaximum", 4.5);

					addToVariablesB("stacker_HeightToteMinimum", 4.5);
					addToVariablesB("stacker_HeightToteMaximum", 20.0);
	}
}
