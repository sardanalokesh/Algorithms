package lsardana.algorithms;

/**
 * 
 * @author lokesh.sardana
 * 
 * An inversion is a pair (i,j) of array indices with i < j and A[i] > A[j]
 * Time Complexity: O(nlogn)
 *
 */

public class Inversions {
	
		private int[] inputArray;
		private InversionResultSet finalResult;
	
		public Inversions(int[] array) {
			inputArray = array;
			finalResult = sortAndCount(inputArray);
		}
	
		public int getInversionCount() {
			return finalResult.getInversionCount();
		}
		
		public int[] getSortedArray() {
			return finalResult.getArray();
		}

		private InversionResultSet sortAndCount(int[] inputArray) {
			int inputSize = inputArray.length;
			if (inputSize <= 1)
				return new InversionResultSet(inputArray, 0);
			else {
				int[] firstHalf = new int[(int) Math.ceil(inputSize/2.0)];
				int[] secondHalf = new int[(int) Math.floor(inputSize/2.0)];
				System.arraycopy(inputArray, 0, firstHalf, 0, firstHalf.length);
				System.arraycopy(inputArray, firstHalf.length, secondHalf, 0, secondHalf.length);
				InversionResultSet firstHalfResultSet = sortAndCount(firstHalf);
				InversionResultSet secondHalfResultSet = sortAndCount(secondHalf);
				InversionResultSet finalResultSet = mergeAndCountSplitInversions(firstHalfResultSet, secondHalfResultSet);
				return finalResultSet;
			}
		}
		
		private InversionResultSet mergeAndCountSplitInversions(InversionResultSet firstHalf, InversionResultSet secondHalf) {
			int inversionCount = firstHalf.getInversionCount() + secondHalf.getInversionCount();
			int[] firstHalfArray = firstHalf.getArray();
			int[] secondHalfArray = secondHalf.getArray();
			int[] sortedMergedArray = new int[firstHalfArray.length + secondHalfArray.length];
			int i = 0;
			int j = 0;
			int k = 0;
			
			while (i < firstHalfArray.length && j < secondHalfArray.length) {
				if (firstHalfArray[i] <= secondHalfArray[j]) {
					sortedMergedArray[k++] = firstHalfArray[i++];
				} else {
					sortedMergedArray[k++] = secondHalfArray[j++];
					//when an element from second array is moved, count the no. of remaining elements in the first array
					inversionCount += (firstHalfArray.length - i);
				}
			}
			
			while (i < firstHalfArray.length) {
				sortedMergedArray[k++] = firstHalfArray[i++];
			}
			
			while (j < secondHalfArray.length) {
				sortedMergedArray[k++] = secondHalfArray[j++];
			}
			
			return new InversionResultSet(sortedMergedArray, inversionCount);
		}
}

final class InversionResultSet {
	private int inversionCount;
	private int[] array;
	
	public InversionResultSet(int[] arry, int count) {
		inversionCount = count;
		array = arry;
	}
	
	public int getInversionCount() {
		return inversionCount;
	}
	
	public int[] getArray() {
		return array;
	}
}
