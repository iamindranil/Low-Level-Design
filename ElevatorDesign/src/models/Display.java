package models;

import enums.Direction;

public class Display {
	int currentFloor;
	Direction direction;
	Display(int currentFloor,Direction direction){
		this.currentFloor=currentFloor;
		this.direction=direction.IDLE;
	}
}
