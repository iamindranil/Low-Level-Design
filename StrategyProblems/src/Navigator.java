import Model.Point;
import Route.RouteStrategy;

public class Navigator {
	RouteStrategy routeStrat;
	
	public Navigator(RouteStrategy routeStrat) {
		this.routeStrat=routeStrat;
	}
	
	public void doNavigation(Point p1,Point p2) {
		if(routeStrat!=null) {
			throw new IllegalStateException("Route strategy must be set before navigation.");
		}
		routeStrat.Route(p1, p2);
	}
}
