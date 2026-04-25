package Controllers;

import java.util.ArrayList;
import java.util.List;

import Strategies.DispatchStrategy;
import enums.Direction;

public class SystemDispatcher{
	private List<ElevatorController> controllers=new ArrayList<ElevatorController>();
	DispatchStrategy dispatchStrategy;
	public SystemDispatcher(DispatchStrategy dispatchStrategy) {
		this.dispatchStrategy=dispatchStrategy;
	}
	public void addController(ElevatorController controller) {
		controllers.add(controller);
	}
	
	//called from inside elevator car
	public ElevatorController getControllerById(int id) {
        for (ElevatorController controller : controllers) {
            if (controller.car.id==id) {
                return controller;
            }
        }
        return null; 
    }
	
	// Called when someone pushes a hall button
	public void dispatchElevator(int floor, Direction direction) {
		ElevatorController bestElevatorController=dispatchStrategy.findSuitableElevatorController(floor,direction);
		if(bestElevatorController!=null)bestElevatorController.acceptRequest(floor,direction);
	}
}
