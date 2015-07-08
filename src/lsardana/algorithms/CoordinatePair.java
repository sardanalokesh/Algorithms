package lsardana.algorithms;
/**
 * @author lokesh.sardana
 * 
 */

public class CoordinatePair {
	private Coordinates first;
	private Coordinates second;
	
	public CoordinatePair(Coordinates c1, Coordinates c2) {
		first = c1;
		second = c2;
		
	}
	public Coordinates getFirst() {
		return first;
	}
	public void setFirst(Coordinates first) {
		this.first = first;
	}
	public Coordinates getSecond() {
		return second;
	}
	public void setSecond(Coordinates second) {
		this.second = second;
	}
	
	public double getEuclideanDistance() {
			return Math.sqrt(Math.pow((this.first.getX() - this.second.getX()), 2)
						 + Math.pow((this.first.getY() - this.second.getY()), 2));
	}
	
	public String toString() {
		return first.toString() + " and " + second.toString();
	}
	

}
