package models;

import enums.DoorState;

public class Door {
	DoorState doorState=DoorState.CLOSED;
	public void open() {
		doorState=DoorState.OPEN;
	}
	public void close() {
		doorState=DoorState.CLOSED;
	}
}
