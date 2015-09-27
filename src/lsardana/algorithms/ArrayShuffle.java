package lsardana.algorithms;

import java.util.Arrays;

/**
 * 
 * @author lokesh.sardana
 * 
 * algorithm to shuffle an array of integers
 * time complexity: O(n*n)
 *
 */

public class ArrayShuffle {
	public static void main(String[] args) {
			
			int[] test1 = {1,2,3,4,5,6,7,8,9};
			ArrayShuffle as = new ArrayShuffle();
			as.shuffle(test1);
			System.out.println(Arrays.toString(test1));
			as.shuffle(test1);
			System.out.println(Arrays.toString(test1));
			as.shuffle(test1);
			System.out.println(Arrays.toString(test1));
	}
	
	public void shuffle(int[] inputArray) {
		int[] temp = new int[inputArray.length];
		System.arraycopy(inputArray, 0, temp, 0, inputArray.length);
		for (int i = 0; i < inputArray.length; i++) {
			int j = (int) (temp.length*Math.random());
			inputArray[i] = temp[j];
			temp = removeElementFromArray(temp, j);
		}
	}
	
	private int[] removeElementFromArray(int[] array, int index) {
		int j = 0;
		int[] arr1 = new int[array.length - 1];
		for (int i = 0; i < array.length; i++) {
			if (i == index) {
				continue;
			}
			arr1[j] = array[i];
			j++;
		}
		return arr1;
	}
}
