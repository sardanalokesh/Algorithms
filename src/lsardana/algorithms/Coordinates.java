package lsardana.algorithms;
/**
 * @author lokesh.sardana
 */
public class Coordinates {
	private double x;
	private double y;
	
	public Coordinates(double xValue, double yValue) {
		this.x = xValue;
		this.y = yValue;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public String toString() {
		return "(" + String.valueOf(this.x) + ", " + String.valueOf(this.y) + ")";
	}
}