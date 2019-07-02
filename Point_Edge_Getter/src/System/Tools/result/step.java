package System.Tools.result;

import System.Tools.point;

public class step {
	private int leg_index;
	private int direction;
	private int distance;
	private String road_name;
	private int road_type;
	private int toll;
	private int toll_distance;
	private String toll_gate_name;
	private point toll_gate_location;
	private point start_location;
	private point end_location;
	private Condition traffic_condition;
	public int getLeg_index() {
		return leg_index;
	}
	public void setLeg_index(int leg_index) {
		this.leg_index = leg_index;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getRoad_name() {
		return road_name;
	}
	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}
	public int getRoad_type() {
		return road_type;
	}
	public void setRoad_type(int road_type) {
		this.road_type = road_type;
	}
	public int getToll() {
		return toll;
	}
	public void setToll(int toll) {
		this.toll = toll;
	}
	public int getToll_distance() {
		return toll_distance;
	}
	public void setToll_distance(int toll_distance) {
		this.toll_distance = toll_distance;
	}
	public String getToll_gate_name() {
		return toll_gate_name;
	}
	public void setToll_gate_name(String toll_gate_name) {
		this.toll_gate_name = toll_gate_name;
	}
	public point getToll_gate_location() {
		return toll_gate_location;
	}
	public void setToll_gate_location(point toll_gate_location) {
		this.toll_gate_location = toll_gate_location;
	}
	public point getStart_location() {
		return start_location;
	}
	public void setStart_location(point start_location) {
		this.start_location = start_location;
	}
	public point getEnd_location() {
		return end_location;
	}
	public void setEnd_location(point end_location) {
		this.end_location = end_location;
	}
	public Condition getTraffic_condition() {
		return traffic_condition;
	}
	public void setTraffic_condition(Condition traffic_condition) {
		this.traffic_condition = traffic_condition;
	}
	
}
