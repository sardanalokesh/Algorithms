package lsardana.algorithms;
/**
 * @author lokesh.sardana
 */
public class Coordinates {
	private int x;
	private int y;
	
	public Coordinates(int xValue, int yValue) {
		this.x = xValue;
		this.y = yValue;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {
		return "(" + String.valueOf(this.x) + ", " + String.valueOf(this.y) + ")";
	}
}