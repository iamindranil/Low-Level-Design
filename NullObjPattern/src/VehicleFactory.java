
public class VehicleFactory {
	
	static Vehicle getVehicle(String vehicle) {
		if(vehicle.equals("Car")){
			return new Car();
		}else {
			return new NullObj();
		}
	}
}
