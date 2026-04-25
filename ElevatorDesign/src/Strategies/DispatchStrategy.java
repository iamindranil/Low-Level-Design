package Strategies;

import Controllers.ElevatorController;
import enums.Direction;

public interface DispatchStrategy {
	ElevatorController findSuitableElevatorController(int floor, Direction direction);
}
