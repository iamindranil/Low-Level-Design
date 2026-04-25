package Controllers;

import java.util.Collections;
import java.util.TreeSet;


import enums.Direction;
import models.ElevatorCar;

public class ElevatorController implements Runnable{
	ElevatorCar car;
	//need Set and PQ together so TreeSet is the best choice(PQ lookup O(N) very slow)
	private TreeSet<Integer>upReqts;
	private TreeSet<Integer>downReqts;
	
	private final Object lockObject=new Object();
	
	public ElevatorController(ElevatorCar car) {
		this.car=car;
		upReqts=new TreeSet<Integer>();
		downReqts=new TreeSet<Integer>(Collections.reverseOrder());
	}
	
	public void acceptRequest(int floor,Direction direction) {
		
		//adding floor so made it thread safe
		//Critical Section 
		synchronized (lockObject) {
			if(direction==Direction.UP) {
				upReqts.add(floor);
			}else {
				downReqts.add(floor);
			}
		}
	}

	@Override
	public void run() {
		while(true) {
			processRequest();
		}
	}

	private void processRequest() {
		//giving priority for upQueue first as of now as default floor is 0.
		//we can remove that biasness on later optimization
		
		//serve up once done check downReq is not empty serve it else make idle 
		if(car.currentDirection==Direction.UP||car.currentDirection==Direction.IDLE) {
			processUpRequests();
			
			synchronized (lockObject) {
				if(downReqts.isEmpty()) {
					car.currentDirection=Direction.IDLE;
				}else {
					car.currentDirection=Direction.DOWN;
				}
			}
		}
		//serve down once done check upReq is not empty serve it else make idle 
		if(car.currentDirection==Direction.DOWN) {
			processDownRequests();
			
			synchronized (lockObject) {
				if(upReqts.isEmpty()) {
					car.currentDirection=Direction.IDLE;
				}else {
					car.currentDirection=Direction.UP;
				}
			}
		}
		
	}

	
	private void processUpRequests() {
		while(true) {
			//find next floor to be served
			Integer nextFloor=null;
			synchronized (lockObject) {
				if(!upReqts.isEmpty()) {
					nextFloor=upReqts.ceiling(car.currentFloor);
				}
			}
			if(nextFloor!=null) {
				car.currentDirection=Direction.UP;
				car.move(nextFloor);
				car.door.open();
				car.door.close();
				upReqts.remove(nextFloor);
			}else {
				//if no up req then need to check someone from lower floor requested for up Req or not
				// We must move down to the lowest user 
                // to restart our upward journey.
				synchronized (lockObject) {
					if(!upReqts.isEmpty() && downReqts.isEmpty()) {
						int lowestFloor=upReqts.first();
						//change direction
						car.currentDirection=Direction.DOWN;
						car.move(lowestFloor);
						//door open close not needed right now as we did direction change and car reached lowestfloor now
						//***loop breaks and then again processUpRequests() will be called 
						//***after serving user's up req it automatically remove it 
					}
				}
				break;
			}
		}
	}
	
	
	private void processDownRequests() {
		while(true) {
			//find next floor to be served
			Integer nextFloor=null;
			synchronized (lockObject) {
				if(!downReqts.isEmpty()) {
					nextFloor=upReqts.floor(car.currentFloor);
				}
			}
			if(nextFloor!=null) {
				car.currentDirection=Direction.DOWN;
				car.move(nextFloor);
				car.door.open();
				car.door.close();
				upReqts.remove(nextFloor);
			}else {
				//if no up req then need to check someone from lower floor requested for up Req or not
				// We must move down to the lowest user 
                // to restart our upward journey.
				synchronized (lockObject) {
					if(!downReqts.isEmpty() && upReqts.isEmpty()) {
						// bcz downRequests is reverse ordered(MaxHeap style)
                        // first() grabs the absolute HIGHEST stranded floor now
						int highestFloor=upReqts.first();
						//change direction
						car.currentDirection=Direction.UP;
						car.move(highestFloor);
						//door open close not needed right now as we did direction change and car reached lowestfloor now
						//***loop breaks and then again processDownRequests() will be called 
						//***after serving user's up req it automatically remove it 
					}
				}
				break;
			}
		}
	}

	
	
}
