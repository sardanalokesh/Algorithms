package lsardana.algorithms;

import java.util.Arrays;

/**
 * 
 * @author lokesh.sardana
 *
 * shuffle an array of objects
 * time complexity: O(n) 
 */
public class FisherYatesShuffle {
	
	public static void main(String[] args) {
		Integer[] test1 = {1,2,3,4,5,6,7,8,9};
		FisherYatesShuffle fys = new FisherYatesShuffle();
		fys.shuffle(test1);
		System.out.println(Arrays.toString(test1));
		fys.shuffle(test1);
		System.out.println(Arrays.toString(test1));
		fys.shuffle(test1);
		System.out.println(Arrays.toString(test1));

	}
	
	public void shuffle(Object[] inputArray) {
		for (int i = inputArray.length - 1; i > 0; i--) {
			int randomIndex = (int) (i*Math.random());
			Object temp = new Object();
			temp = inputArray[i];
			inputArray[i] = inputArray[randomIndex];
			inputArray[randomIndex] = temp;
		}
	}
}
