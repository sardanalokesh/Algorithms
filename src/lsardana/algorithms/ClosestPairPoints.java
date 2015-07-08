package lsardana.algorithms;
/**
 * @author lokesh.sardana
 * 
 * Work in Progress
 * 
 */
import java.util.ArrayList;

public class ClosestPairPoints {

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
			double d1 = pair1.getEuclideanDistance();
			double d2 = pair2.getEuclideanDistance();
			double delta = Math.min(d1, d2);
			CoordinatePair pair3 = closestSplitPair(pX, pY, delta);
			return getBestPair(pair1, pair2, pair3);
		}
	}
	
	private CoordinatePair closestSplitPair(Coordinates[] pX, Coordinates[] pY, double delta) {
		double best = delta;
		CoordinatePair bestPair = null;
		int xBar = pX[(int)Math.ceil(pX.length/2.0) - 1].getX();
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
		double d1 = pair1.getEuclideanDistance();
		double d2 = pair2.getEuclideanDistance();
		double d3 = pair3.getEuclideanDistance();
		
		if (d1 < d2 && d1 < d3)
			return pair1;
		else if (d2 < d1 && d2 < d3)
			return pair2;
		else
			return pair3;
	}
	
}