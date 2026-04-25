package models.buttons;

public class ElevatorButton implements Button{
	private int destinationFloor;
	public ElevatorButton(int destinationFloor) {
		this.destinationFloor=destinationFloor;
		
	}
	@Override
	public void press() {
		System.out.println("ElevatorButton Pressed");
	}
}
