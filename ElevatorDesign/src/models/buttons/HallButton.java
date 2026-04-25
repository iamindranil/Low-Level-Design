package models.buttons;

import enums.Direction;

public class HallButton implements Button{
	private Direction direction;
	public HallButton(Direction direction) {
		this.direction=direction;
	}

	@Override
	public void press() {
		System.out.println("HallButton Pressed");
	}

}
