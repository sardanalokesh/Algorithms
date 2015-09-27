package lsardana.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] a1 = {100,44,99,2,7,1,9,1,8,3,0,2,8,3,8,5};
		int[] a2 = {5,8,7,6,4,9,8,6,7,5,3,2,1,2,3,4,34,12,553};
		BubbleSort bs = new BubbleSort();
		bs.sort(a1, a1.length);
		bs.sort(a2, a2.length);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));

	}
	
	public void sort(int[] A, int n) {
		for (int pass = n-1; pass > 0; pass--) {
			boolean swapped = false;
			for (int i = 0; i < pass; i++) {
				if (A[i] > A[i+1]) {
					swap(A, i, i+1);
					swapped = true;
				}
			}
			if (!swapped)
				return;
		}
	}
	
	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
