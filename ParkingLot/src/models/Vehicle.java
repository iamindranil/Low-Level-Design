package models;
import enums.VehicleType;

public class Vehicle {
	private ParkingFloor floor;
	private int vehicleNo;
	private VehicleType vehicleType;
	public Vehicle(ParkingFloor floor,int vehicleNo,VehicleType vehicleType){
		this.floor=floor;
		this.vehicleNo=vehicleNo;
		this.vehicleType=vehicleType;
	}
	
	public ParkingFloor getFloor() {
		return floor;
	}
	
	public int getVehicleNo() {
		return vehicleNo;
	}
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
}
