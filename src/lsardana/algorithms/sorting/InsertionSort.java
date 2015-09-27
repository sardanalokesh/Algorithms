package lsardana.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a1 = {100,44,99,2,7,1,9,1,8,3,0,2,8,3,8,5};
		int[] a2 = {5,8,7,6,4,9,8,6,7,5,3,2,1,2,3,4,34,12,553};
		InsertionSort is = new InsertionSort();
		is.sort(a1, a1.length);
		is.sort(a2, a2.length);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));

	}
	
	public void sort(int[] A, int n) {
		for (int i = 1; i < n; i++) {
			int value = A[i];
			int hole = i;
			while (hole > 0 && A[hole-1] > value) {
				A[hole] = A[hole - 1];
				hole--;
			}
			A[hole] = value;
		}
	}

}
