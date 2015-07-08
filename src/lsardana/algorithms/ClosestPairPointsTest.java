package lsardana.algorithms;
/**
 * @author lokesh.sardana
 */

public class ClosestPairPointsTest {

	public static void main(String[] args) {
		ClosestPairPoints cpp = new ClosestPairPoints();
		Coordinates[] example1 = {new Coordinates(1,6),new Coordinates(5,2),new Coordinates(2,1),new Coordinates(4,4),new Coordinates(7,6),new Coordinates(8,3)};
		System.out.println("Points:"+Helper.getCoordinateArrayString(example1)+" Closest Pair:"+cpp.get(example1).toString());
	}

}
