package services;

import java.util.List;

import enums.VehicleType;
import managers.ParkingSpotManager;
import managers.ParkingSpotManagerFactory;
import models.ParkingFloor;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;

public class ParkingLot {
	private List<ParkingFloor> floors;
	
	public ParkingLot() {
		this.floors=floors;
	}
	
	public void addFloor(ParkingFloor floor) {
		this.floors.add(floor);
	}
	
	private ParkingSpotManager getManager(Vehicle vehicle) {
		ParkingSpotManagerFactory parkingSpotManagerFactory=new ParkingSpotManagerFactory();
		List<ParkingSpot> spots=vehicle.getFloor().getSpots();
		return parkingSpotManagerFactory.getParkingSpotManager(vehicle.getVehicleType(),spots);
	}
	
	public Ticket parkVehicle(Vehicle vehicle) {
		ParkingSpotManager parkingManager=getManager(vehicle);
		parkingManager.parkVehicle(vehicle);
		for(ParkingSpot spot:vehicle.getFloor().getSpots()) {
			if(spot!=null) {
				return new Ticket(System.currentTimeMillis(),spot,vehicle);
			}
		}
		return null;
	}
	
	public void removeVehicle(Ticket ticket) {
		ParkingSpotManager parkingManager=getManager(ticket.getVehicle());
		parkingManager.removeVehicle(ticket.getVehicle());
		
	}
	
}
