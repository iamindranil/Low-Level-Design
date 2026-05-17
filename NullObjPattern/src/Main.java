
public class Main {

	public static void main(String[] args) {
		Vehicle vehicle=VehicleFactory.getVehicle("Car");
		printVehicleDetails(vehicle);
	}

	private static void printVehicleDetails(Vehicle vehicle) {
		System.out.println(vehicle.getAvailableSeat()+vehicle.getPrice());
	}
	
	

}
