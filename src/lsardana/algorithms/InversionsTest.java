package lsardana.algorithms;

/**
 * @author lokesh.sardana
 */

import java.util.Arrays;

public class InversionsTest {

	public static void main(String[] args) {
		
		long[] example1 = {1,3,5,2,4,6};
		long[] example2 = {1,2,3,4,5,6};
		long[] example3 = {8,12,3,10,15};
		long[] example4 = {20,2,5,4,10,3,18};
		
		Inversions inv1 = new Inversions(example1);
		Inversions inv2 = new Inversions(example2);
		Inversions inv3 = new Inversions(example3);
		Inversions inv4 = new Inversions(example4);
		System.out.println("Input array: "+Arrays.toString(example1)+" Sorted Array: "+Arrays.toString(inv1.getSortedArray())+" inversion count: "+inv1.getInversionCount());
		System.out.println("Input array: "+Arrays.toString(example2)+" Sorted Array: "+Arrays.toString(inv2.getSortedArray())+" inversion count: "+inv2.getInversionCount());
		System.out.println("Input array: "+Arrays.toString(example3)+" Sorted Array: "+Arrays.toString(inv3.getSortedArray())+" inversion count: "+inv3.getInversionCount());
		System.out.println("Input array: "+Arrays.toString(example4)+" Sorted Array: "+Arrays.toString(inv4.getSortedArray())+" inversion count: "+inv4.getInversionCount());
	}

}
