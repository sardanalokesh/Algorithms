package lsardana.algorithms.sorting;

import java.util.Arrays;


public class QuickSort {
	
	public static void main(String[] args) {
		int[] a1 = {100,44,99,2,7,1,9,1,8,3,0,2,8,3,8,5};
		int[] a2 = {5,8,7,6,4,9,8,6,7,5,3,2,1,2,3,4,34,12,553};
		QuickSort qs = new QuickSort();
		qs.sort(a1, 0, a1.length - 1);
		qs.sort(a2, 0, a2.length - 1);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
	}
	
	public void sort(int A[], int low, int high) {
		int pivot;
		if (high > low) {
			pivot = partition(A, low, high);
			sort(A, low, pivot -1);
			sort(A, pivot + 1, high);
		}
	}
	
	private int partition(int A[], int low, int high) {
		int pivotValue = A[low];
		int left = low;
		int right = high;
		while (left < right) {
			while (left <= high && A[left] <= pivotValue)
				left++;
			while (right >= low && A[right] > pivotValue)
				right--;
			if (left < right)
				swap(A, left, right);
		}
		A[low] = A[right];
		A[right] = pivotValue;
		return right;
	}
	
	private void swap(int[] A, int x, int y) {
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}
}
