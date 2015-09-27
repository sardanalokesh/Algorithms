package lsardana.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] a1 = {100,44,99,2,7,1,9,1,8,3,0,2,8,3,8,5};
		int[] a2 = {5,8,7,6,4,9,8,6,7,5,3,2,1,2,3,4,34,12,553};
		SelectionSort ss = new SelectionSort();
		ss.sort(a1, a1.length);
		ss.sort(a2, a2.length);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));

	}
	
	public void sort(int[] A, int n) {
		for (int i = 0; i < n-1; i++) {
			int min = i;
			for (int j = i+1; j < n; j++) {
				if (A[j] < A[min]) {
					min = j;
				}
			}
			swap(A, i, min);
		}
	}
	
	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
