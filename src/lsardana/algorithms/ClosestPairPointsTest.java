package lsardana.algorithms;
/**
 * @author lokesh.sardana
 */

public class ClosestPairPointsTest {

	public static void main(String[] args) {
		ClosestPairPoints cpp = new ClosestPairPoints();
		Coordinates[] example1 = {new Coordinates(1,6),new Coordinates(5,2),new Coordinates(2,1),new Coordinates(4,4),new Coordinates(7,6),new Coordinates(8,3)};
		Coordinates[] example2 = {new Coordinates(0,0),new Coordinates(13,2),new Coordinates(2,16),new Coordinates(1,1),new Coordinates(7,6),new Coordinates(2,2)};
		Coordinates[] example3 = {new Coordinates(2,3),new Coordinates(12,30),new Coordinates(40,50),new Coordinates(5,1),new Coordinates(12,10),new Coordinates(3,4)};
		System.out.println("Points:"+Helper.getCoordinateArrayString(example1)+" Closest Pair:"+cpp.get(example1).toString() + " closest distance: " + cpp.get(example1).getEuclideanDistance());
		System.out.println("Points:"+Helper.getCoordinateArrayString(example2)+" Closest Pair:"+cpp.get(example2).toString() + " closest distance: " + cpp.get(example2).getEuclideanDistance());
		System.out.println("Points:"+Helper.getCoordinateArrayString(example3)+" Closest Pair:"+cpp.get(example3).toString() + " closest distance: " + cpp.get(example3).getEuclideanDistance());
	}

}
