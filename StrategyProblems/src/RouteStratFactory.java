import Route.Drive;
import Route.RouteStrategy;
import Route.Walk;

public class RouteStratFactory {
	public RouteStrategy getStrategy(String mode) {
		if(mode==null)return null;
		if(mode.toUpperCase().equals("DRIVE")) {
			return new Drive();
		}else if(mode.toUpperCase().equals("WALK")) {
			return new Walk();
		}else {
			 throw new IllegalArgumentException("Unkniown mode: "+mode);
		}
	}
}
