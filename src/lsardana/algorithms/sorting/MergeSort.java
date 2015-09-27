package lsardana.algorithms.sorting;

import java.util.Arrays;

/**
 * 
 * @author lokesh.sardana
 *
 */

public class MergeSort {
	
	public int[] sort(int[] inputArray) {
		int arraySize = inputArray.length;
		if (inputArray.length <= 1) {
			return inputArray;
		}
		else {
			int[] firstHalf = new int[(int) Math.ceil(arraySize/2.0)];
			int[] secondHalf = new int[(int) Math.floor(arraySize/2.0)];
			System.arraycopy(inputArray, 0, firstHalf, 0, firstHalf.length);
			System.arraycopy(inputArray, firstHalf.length, secondHalf, 0, secondHalf.length);
			firstHalf = sort(firstHalf);
			secondHalf = sort(secondHalf);
			int[] mergedArray = merge(firstHalf, secondHalf);
			return mergedArray;
		}
		
	}

	private int[] merge(int[] firstHalf, int[] secondHalf) {
		int[] result = new int[firstHalf.length + secondHalf.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < firstHalf.length && j < secondHalf.length) {
			if (firstHalf[i] <= secondHalf[j]) {
				result[k++] = firstHalf[i++];
			} else {
				result[k++] = secondHalf[j++];
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
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] example1 = {1,5,2,4,7,8};
		int[] example2 = {1,5,2,4,7};
		int[] example3 = {1};
		int[] example4 = {1,5,2,4,7,8,5,3,1};
		System.out.println("Original:"+Arrays.toString(example1)+" Sorted:"+Arrays.toString(ms.sort(example1)));
		System.out.println("Original:"+Arrays.toString(example2)+" Sorted:"+Arrays.toString(ms.sort(example2)));
		System.out.println("Original:"+Arrays.toString(example3)+" Sorted:"+Arrays.toString(ms.sort(example3)));
		System.out.println("Original:"+Arrays.toString(example4)+" Sorted:"+Arrays.toString(ms.sort(example4)));
	}

}
