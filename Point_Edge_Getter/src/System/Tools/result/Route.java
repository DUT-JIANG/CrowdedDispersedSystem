package System.Tools.result;

import System.Tools.point;

public class Route {
	private point src;
	private point dst;
	private int total;
	private step[] steps;
	public point getSrc() {
		return src;
	}
	public void setSrc(point src) {
		this.src = src;
	}
	public point getDst() {
		return dst;
	}
	public void setDst(point dst) {
		this.dst = dst;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public step[] getSteps() {
		return steps;
	}
	public void setSteps(step[] steps) {
		this.steps = steps;
	}
	
}
