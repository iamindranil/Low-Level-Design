import Controllers.ElevatorController;
import Controllers.SystemDispatcher;
import Strategies.ShortestDistanceStrategy;
import enums.Direction;
import models.ElevatorCar;

public class Main {
	public static void main(String[]args){
		SystemDispatcher dispatcher=new SystemDispatcher(new ShortestDistanceStrategy());
		
		for(int i=0;i<3;i++) {
			ElevatorCar car = new ElevatorCar(i);
            ElevatorController controller = new ElevatorController(car);
            dispatcher.addController(controller);
            new Thread(controller).start();
		}
		
		//External button request
		dispatcher.dispatchElevator(6,Direction.UP);
		
		dispatcher.dispatchElevator(8,Direction.DOWN);
	}
}
