package System.Tools;

import System.Tools.result.Route;

public class ApiReturn {
	private Route[] routes;
	private String restriction;
	private int total;
	public Route[] getRoutes() {
		return routes;
	}
	public void setRoutes(Route[] routes) {
		this.routes = routes;
	}
	public String getRestriction() {
		return restriction;
	}
	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public ApiReturn(String JSON){
		
	}
}
