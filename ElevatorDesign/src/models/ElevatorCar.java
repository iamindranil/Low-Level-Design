package models;

import enums.Direction;
import enums.ElevatorState;

public class ElevatorCar {
	public int id;
	public int currentFloor;
	public Direction currentDirection;
	public ElevatorState state;
	public Door door;
	public Display display;
	
	public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = 0; // Ground floor
        this.currentDirection = Direction.IDLE;
        this.state = ElevatorState.STOPPED;
        this.door = new Door();
        this.display = new Display(currentFloor,currentDirection);
    }
	
	public void move(int destinationFloor) {
		this.state=ElevatorState.MOVING;
		//delay
		try {Thread.sleep(500);}catch(Exception e) {}
		this.currentFloor=destinationFloor;
		this.state=ElevatorState.STOPPED;
	}
}
