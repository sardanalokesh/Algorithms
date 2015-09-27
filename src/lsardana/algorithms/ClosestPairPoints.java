package lsardana.algorithms;
/**
 * @author lokesh.sardana
 * 
 */
import java.util.ArrayList;

public class ClosestPairPoints {
	
	public static void main(String[] args) {
		ClosestPairPoints cpp = new ClosestPairPoints();
		Coordinates[] example1 = {new Coordinates(1,6),new Coordinates(5,2),new Coordinates(2,1),new Coordinates(4,4),new Coordinates(7,6),new Coordinates(8,3)};
		Coordinates[] example2 = {new Coordinates(0,0),new Coordinates(13,2),new Coordinates(2,16),new Coordinates(1,1),new Coordinates(7,6),new Coordinates(2,2)};
		Coordinates[] example3 = {new Coordinates(2,3),new Coordinates(12,30),new Coordinates(40,50),new Coordinates(5,1),new Coordinates(12,10),new Coordinates(3,4)};
		System.out.println("Points:"+Helper.getCoordinateArrayString(example1)+" Closest Pair:"+cpp.get(example1).toString() + " closest distance: " + cpp.get(example1).getEuclideanDistance());
		System.out.println("Points:"+Helper.getCoordinateArrayString(example2)+" Closest Pair:"+cpp.get(example2).toString() + " closest distance: " + cpp.get(example2).getEuclideanDistance());
		System.out.println("Points:"+Helper.getCoordinateArrayString(example3)+" Closest Pair:"+cpp.get(example3).toString() + " closest distance: " + cpp.get(example3).getEuclideanDistance());
	}

	public CoordinatePair get(Coordinates[] points) {
		CoordinatePair result = null;
		CoordinatesMergeSort cms = new CoordinatesMergeSort();
		Coordinates[] pointsX = cms.sort(points,'x');
		Coordinates[] pointsY = cms.sort(points,'y');
		result = closestPair(pointsX, pointsY);
		return result;
	}
	
	private CoordinatePair closestPair(Coordinates[] pX, Coordinates[] pY) {
		if (pX.length < 2) {
			return null;
		} else if (pX.length == 2) {
			return new CoordinatePair(pX[0],pX[1]);
		} else {
			Coordinates[] qX = new Coordinates[(int) Math.ceil(pX.length/2.0)];
			Coordinates[] rX = new Coordinates[(int) Math.floor(pX.length/2.0)];
			Coordinates[] qY = new Coordinates[(int) Math.ceil(pY.length/2.0)];
			Coordinates[] rY = new Coordinates[(int) Math.floor(pY.length/2.0)];
			System.arraycopy(pX, 0, qX, 0, qX.length);
			System.arraycopy(pX, qX.length, rX, 0, rX.length);
			System.arraycopy(pY, 0, qY, 0, qY.length);
			System.arraycopy(pY, qY.length, rY, 0, rY.length);
			CoordinatePair pair1 = closestPair(qX, qY);
			CoordinatePair pair2 = closestPair(rX, rY);
			double d1;
			double d2;
			if (pair1 != null) {
				d1 = pair1.getEuclideanDistance();
			} else {
				d1 = Double.POSITIVE_INFINITY;
			}
			if (pair2 != null) {
				d2 = pair2.getEuclideanDistance();
			} else {
				d2 = Double.POSITIVE_INFINITY;
			}
			double delta = Math.min(d1, d2);
			CoordinatePair pair3 = closestSplitPair(pX, pY, delta);
			return getBestPair(pair1, pair2, pair3);
		}
	}
	
	private CoordinatePair closestSplitPair(Coordinates[] pX, Coordinates[] pY, double delta) {
		double best = delta;
		CoordinatePair bestPair = null;
		double xBar = pX[(int)Math.ceil(pX.length/2.0) - 1].getX();
		ArrayList<Coordinates> sY = new ArrayList<Coordinates>();
		for (Coordinates c : pY) {
			if (c.getX() > xBar - delta && c.getX() < xBar + delta) {
				sY.add(c);
			}
		}
		for (int i = 0; i < sY.size(); i++) {
			for (int j = 1; j < Math.min(7, sY.size() - i); j++) {
				CoordinatePair pair = new CoordinatePair(sY.get(i), sY.get(i+j));
				if (pair.getEuclideanDistance() < best) {
					best = pair.getEuclideanDistance();
					bestPair = pair;
				}
			}
		}
		return bestPair;	
	}
	
	private CoordinatePair getBestPair(CoordinatePair pair1, CoordinatePair pair2, CoordinatePair pair3) {
		double d1;
		double d2;
		double d3;
		if (pair1 != null) {
			d1 = pair1.getEuclideanDistance();
		} else {
			d1 = Double.POSITIVE_INFINITY;
		}
		if (pair2 != null) {
			d2 = pair2.getEuclideanDistance();
		} else {
			d2 = Double.POSITIVE_INFINITY;
		}
		if (pair3 != null) {
			d3 = pair3.getEuclideanDistance();
		} else {
			d3 = Double.POSITIVE_INFINITY;
		}
		
		if (d1 < d2 && d1 < d3)
			return pair1;
		else if (d2 < d1 && d2 < d3)
			return pair2;
		else
			return pair3;
	}
	
}