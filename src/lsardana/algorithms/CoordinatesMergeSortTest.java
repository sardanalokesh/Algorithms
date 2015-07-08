package lsardana.algorithms;
/**
 * 
 * @author lokesh.sardana
 *
 */

public class CoordinatesMergeSortTest {
	
	public static void main(String args[]) {
		CoordinatesMergeSort cms = new CoordinatesMergeSort();
		Coordinates[] example1 = {new Coordinates(1,6),new Coordinates(5,2),new Coordinates(2,1),new Coordinates(4,4),new Coordinates(7,6),new Coordinates(8,3)};
		System.out.println("Original:"+Helper.getCoordinateArrayString(example1)+" Sorted by x:"+Helper.getCoordinateArrayString(cms.sort(example1,'x')));
		System.out.println("Original:"+Helper.getCoordinateArrayString(example1)+" Sorted by y:"+Helper.getCoordinateArrayString(cms.sort(example1, 'y')));
	}

}
