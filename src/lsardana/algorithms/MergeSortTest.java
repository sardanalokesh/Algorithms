package lsardana.algorithms;

/**
 * @author lokesh.sardana
 */

import java.util.Arrays;

public class MergeSortTest {

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
