package lsardana.algorithms;

/**
 * 
 * @author lokesh.sardana
 *
 */

public class CoordinatesMergeSort {
	
	public static void main(String args[]) {
		CoordinatesMergeSort cms = new CoordinatesMergeSort();
		Coordinates[] example1 = {new Coordinates(1,6),new Coordinates(5,2),new Coordinates(2,1),new Coordinates(4,4),new Coordinates(7,6),new Coordinates(8,3)};
		System.out.println("Original:"+Helper.getCoordinateArrayString(example1)+" Sorted by x:"+Helper.getCoordinateArrayString(cms.sort(example1,'x')));
		System.out.println("Original:"+Helper.getCoordinateArrayString(example1)+" Sorted by y:"+Helper.getCoordinateArrayString(cms.sort(example1, 'y')));
	}
	
	public Coordinates[] sort(Coordinates[] inputArray, char sortBy) {
		int arraySize = inputArray.length;
		if (inputArray.length <= 1) {
			return inputArray;
		}
		else {
			Coordinates[] firstHalf = new Coordinates[(int) Math.ceil(arraySize/2.0)];
			Coordinates[] secondHalf = new Coordinates[(int) Math.floor(arraySize/2.0)];
			System.arraycopy(inputArray, 0, firstHalf, 0, firstHalf.length);
			System.arraycopy(inputArray, firstHalf.length, secondHalf, 0, secondHalf.length);
			firstHalf = sort(firstHalf, sortBy);
			secondHalf = sort(secondHalf, sortBy);
			Coordinates[] mergedArray = merge(firstHalf, secondHalf, sortBy);
			return mergedArray;
		}
		
	}

	private Coordinates[] merge(Coordinates[] firstHalf, Coordinates[] secondHalf, char sortBy) {
		Coordinates[] result = new Coordinates[firstHalf.length + secondHalf.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < firstHalf.length && j < secondHalf.length) {
			if (sortBy == 'x') {
				if (firstHalf[i].getX() <= secondHalf[j].getX()) {
					result[k++] = firstHalf[i++];
				} else {
					result[k++] = secondHalf[j++];
				}
			} else if (sortBy == 'y') {
				if (firstHalf[i].getY() <= secondHalf[j].getY()) {
					result[k++] = firstHalf[i++];
				} else {
					result[k++] = secondHalf[j++];
				}
			}
		}
		
		//pushing the remaining elements
		while (i < firstHalf.length) {
			result[k++] = firstHalf[i++];
		}
		
		while (j < secondHalf.length) {
			result[k++] = secondHalf[j++];
		}
		
		return result;
	}

}
