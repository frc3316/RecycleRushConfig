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
				addToConstants("BUTTON_TOTE_PICKUP", 3);
				addToConstants("BUTTON_MOVE_STACKER_TO_TOTE", 4);
				
				addToConstants("BUTTON_OPEN_GRIPPER", 5);
				addToConstants("BUTTON_CLOSE_GRIPPER", 6);
				
				addToConstants("BUTTON_HOLD_CONTAINER", 7);
				addToConstants("BUTTON_RELEASE_CONTAINER", 8);
				
				addToConstants("BUTTON_OPEN_BRAKE", 9);
				addToConstants("BUTTON_CLOSE_BRAKE", 10);		

				
				
				/*
				 * Roller-Gripper
				 */
				addToConstants("BUTTON_ROLL_IN", 180);
				addToConstants("BUTTON_ROLL_OUT", 0);
				addToConstants("BUTTON_ROLL_TURN_CLOCKWISE", 90);
				addToConstants("BUTTON_ROLL_TURN_COUNTER_CLOCKWISE", 270);
				
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
				
				addToConstants("ELEVATOR_MOTOR_CONTROLLER_LEFT", 8); 
				
				addToConstants("ELEVATOR_MOTOR_CONTROLLER_RIGHT", 9);
				
				addToConstants("CHASSIS_MOTOR_CONTROLLER_CENTER", 4);
				
				addToConstants("ROLLER_GRIPPER_MOTOR_CONTROLLER_LEFT", 7);
				addToConstants("ROLLER_GRIPPER_MOTOR_CONTROLLER_RIGHT", 3);
				
				
				
		/*
		 * Chassis
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
			addToConstantsA("CHASSIS_ENCODER_LEFT_DISTANCE_PER_PULSE", ((6*Math.PI) / 32) * 0.0254);
			addToConstantsA("CHASSIS_ENCODER_RIGHT_DISTANCE_PER_PULSE", ((6*Math.PI) / 32) * 0.0254);
			addToConstantsA("CHASSIS_ENCODER_CENTER_DISTANCE_PER_PULSE", ((4*Math.PI) / 32) * 0.0254);
			
			/*
			 * Robot B
			 */
			addToConstantsB("CHASSIS_ENCODER_LEFT_DISTANCE_PER_PULSE", ((6*Math.PI) / 32) * 0.0254);
			addToConstantsB("CHASSIS_ENCODER_RIGHT_DISTANCE_PER_PULSE", ((6*Math.PI) / 32) * 0.0254);
			addToConstantsB("CHASSIS_ENCODER_CENTER_DISTANCE_PER_PULSE", ((4*Math.PI) / 32) * 0.0254);
			
			addToConstants("CHASSIS_ENCODER_LEFT_REVERSE_DIRECTION", true);
			addToConstants("CHASSIS_ENCODER_RIGHT_REVERSE_DIRECTION", false);
			addToConstants("CHASSIS_ENCODER_CENTER_REVERSE_DIRECTION", true);
			
			addToConstants("CHASSIS_WIDTH", 0.5322); //in meters
			/*
			 * Variables
			 */

			 //Subsystem
			addToVariables("chassis_LeftScale", 1.0);
			addToVariables("chassis_RightScale", -1.0);
			addToVariables("chassis_CenterScale", 1.0);
			
			addToVariables("chassis_CenterEncoderScale", 4.0);
			addToVariables("chassis_LeftEncoderScale", 4.0);
			addToVariables("chassis_RightEncoderScale", 4.0);
			
			addToVariables("chassis_HeadingToSet", 0.0); // This is the heading that the SetHeadingSDB command sets to
														 // It is configurable in the SDB (it should appear in initSDB())
			//TankDrive
			addToVariables("chassis_TankDrive_InvertX", false);
			addToVariables("chassis_TankDrive_InvertY", true);
			
			addToVariables("chassis_TankDrive_LowPass", 0.0);
			//RobotOrientedDrive
			addToVariables("chassis_RobotOrientedDrive_TurnScale", 1.0);
			
			//RobotOrientedDrivePIDRotation
			addToVariables("chassis_RobotOrientedDrivePIDRotation_PIDControllerRotation_KP", 0.0);
			addToVariables("chassis_RobotOrientedDrivePIDRotation_PIDControllerRotation_KI", 0.0);
			addToVariables("chassis_RobotOrientedDrivePIDRotation_PIDControllerRotation_KD", 0.0);
			
			addToVariables("chassis_RobotOrientedDrivePIDRotation_PIDControllerRotation_AbsoluteTolerance", 5.0);
			
			addToVariables("chassis_RobotOrientedDrivePIDRotation_PIDControllerRotation_MinimumOutput", -1.0);
			addToVariables("chassis_RobotOrientedDrivePIDRotation_PIDControllerRotation_MaximumOutput", 1.0);
			
			addToVariables("chassis_RobotOrientedDrivePIDRotation_SetpointScale", 180.0);
			
			//RobotOrientedNavigation
			
			//Set 1 - To push container out of the way
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KP_1", 300.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KI_1", 2.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KD_1", 2.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KP_1", 500.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KI_1", 2.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KD_1", 2.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KP_1", 10.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KI_1", 3.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KD_1", 0.1);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_AbsoluteTolerance_1", 0.15);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_AbsoluteTolerance_1", 0.20);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_AbsoluteTolerance_1", 1.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MinimumOutput_1", -0.6);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MaximumOutput_1", 0.6);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MinimumOutput_1", -0.6);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MaximumOutput_1", 0.6);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MinimumOutput_1", -1.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MaximumOutput_1", 1.0);
			
			addToVariables("chassis_RobotOrientedNavigation_MaxFinishCounter_1", 1);
			
			//Set 2 - To return robot back to track after pushing container
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KP_2", 300.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KI_2", 2.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KD_2", 2.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KP_2", 3000.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KI_2", 2.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KD_2", 2.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KP_2", 3.8);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KI_2", 0.045);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KD_2", 0.82);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_AbsoluteTolerance_2", 0.15);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_AbsoluteTolerance_2", 0.05);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_AbsoluteTolerance_2", 5.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MinimumOutput_2", -0.6);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MaximumOutput_2", 0.6);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MinimumOutput_2", -0.6);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MaximumOutput_2", 0.6);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MinimumOutput_2", -0.5);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MaximumOutput_2", 0.5);
			
			addToVariables("chassis_RobotOrientedNavigation_MaxFinishCounter_2", 10);
			
			//Set 3 - To drive forward the distance of a tote and staging zone
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KP_3", 300.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KI_3", 2.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KD_3", 2.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KP_3", 200.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KI_3", 2.2);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KD_3", 1.5);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KP_3", 30.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KI_3", 0.01);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KD_3", 0.015);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_AbsoluteTolerance_3", 0.15);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_AbsoluteTolerance_3", 0.05);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_AbsoluteTolerance_3", 1.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MinimumOutput_3", -0.6);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MaximumOutput_3", 0.6);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MinimumOutput_3", -0.6);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MaximumOutput_3", 0.6);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MinimumOutput_3", -0.5);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MaximumOutput_3", 0.5);
			
			addToVariables("chassis_RobotOrientedNavigation_MaxFinishCounter_3", 5);
			
			//Set 4 - To move the stacked tote set to the autonomous zone
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KP_4", 200.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KI_4", 2.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_KD_4", 1.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KP_4", 200.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KI_4", 4.0);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_KD_4", 1.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KP_4", 1.5);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KI_4", 0.01);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_KD_4", 0.101);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_AbsoluteTolerance_4", 0.2);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_AbsoluteTolerance_4", 0.6);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_AbsoluteTolerance_4", 20.0);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MinimumOutput_4", -0.6);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerX_MaximumOutput_4", 0.6);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MinimumOutput_4", -0.6);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerY_MaximumOutput_4", 0.6);
			
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MinimumOutput_4", -0.5);
			addToVariables("chassis_RobotOrientedNavigation_PIDControllerHeading_MaximumOutput_4", 0.5);
			
			addToVariables("chassis_RobotOrientedNavigation_MaxFinishCounter_4", 1);

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
					
					addToVariables("rollerGripper_GPDistanceAverage_Size", 20);
					addToVariables("rollerGripper_GPDistanceAverage_UpdateRate", 20);
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
					addToVariablesB("rollerGripper_ToteDistanceMinimum", 0.0);
					addToVariablesB("rollerGripper_ToteDistanceMaximum", 0.33);
					
					addToVariablesB("rollerGripper_ContainerDistanceMinimum", 0.35);
					addToVariablesB("rollerGripper_ContainerDistanceMaximum", 0.42);
					
					addToVariablesB("rollerGripper_SomethingDistanceThreshold", 1.0);
					addToVariablesB("rollerGripper_UnsureDistanceThreshold", 1.7);
					
				//AutoRollIn
					addToVariables("rollerGripper_AutoRollIn_Left", 1.0);
					addToVariables("rollerGripper_AutoRollIn_Right", 1.0);
					addToVariables("rollerGripper_AutoRollIn_MaxFinishCounter", 4);
					
				//RollIn
					addToVariables("rollerGripper_PushContainerSequence_LeftSpeed", 1.0);
					addToVariables("rollerGripper_PushContainerSequence_RightSpeed", 1.0);
					
				//Roll Out
					addToVariables("rollerGripper_ReturnToTrackSequence_LeftSpeed", -1.0);
					addToVariables("rollerGripper_ReturnToTrackSequence_RightSpeed", -1.0);
					
				//RollJoystick
					addToVariables("rollerGripper_RollJoystick_ChannelX", 0);
					addToVariables("rollerGripper_RollJoystick_ChannelY", 1);
					
					addToVariables("rollerGripper_RollJoystick_InvertX", false);
					addToVariables("rollerGripper_RollJoystick_InvertY", false);
					
					addToVariables("rollerGripper_RollJoystick_LowPass", 0.15);
					
				//WaitForTote
					addToVariables("rollerGripper_WaitForTote_MaxFinishCounter", 4);
				
					
					
					
		/*
		 * Stacker
		 */
			/*
			 * Constants
			 */
				//Subsystem
					addToConstants("STACKER_SOLENOID_HOLDER_FORWARD", 6);
					addToConstants("STACKER_SOLENOID_HOLDER_REVERSE", 7);
					
					addToConstants("STACKER_SOLENOID_BRAKE_FORWARD", 4);
					addToConstants("STACKER_SOLENOID_BRAKE_REVERSE", 5);
					
					addToConstants("STACKER_SOLENOID_CONTAINER_FORWARD", 3);
					addToConstants("STACKER_SOLENOID_CONTAINER_REVERSE", 2);
					
					addToConstants("STACKER_SOLENOID_GRIPPER_FORWARD", 0);
					addToConstants("STACKER_SOLENOID_GRIPPER_REVERSE", 1);
					
					addToConstants("STACKER_IR", 0);
					
					addToConstants("STACKER_SWITCH_RATCHET_LEFT", 7);
					addToConstants("STACKER_SWITCH_RATCHET_RIGHT", 8);
					addToConstants("STACKER_SWITCH_HEIGHT", 9);
					
					addToConstants("stacker_MoveDown_scale", 0.5);
			/*
			 * Variables
			 */


				//Subsystem
					addToVariables("stacker_HeightAverage_Size", 25);
					addToVariables("stacker_HeightAverage_UpdateRate", 20);
					addToVariables("stacker_MoveDown_Scale", 0.3);
					addToVariables("stacker_MoveUp_Scale", 1.0);
					

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
					addToVariablesB("stacker_HeightFloorMaximum", 0.63);
					
					addToVariablesB("stacker_HeightStepMinimum", 3.75);
					addToVariablesB("stacker_HeightStepMaximum", 4.2);

					addToVariablesB("stacker_HeightToteMinimum", 5.5);
					addToVariablesB("stacker_HeightToteMaximum", 20.0);

					
	}
}
