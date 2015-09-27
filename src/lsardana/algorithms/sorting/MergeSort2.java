package lsardana.algorithms.sorting;

import java.util.Arrays;

public class MergeSort2 {

	public static void main(String[] args) {
		int[] a1 = {100,44,99,2,7,1,9,1,8,3,0,2,8,3,8,5};
		int[] a2 = {5,8,7,6,4,9,8,6,7,5,3,2,1,2,3,4,34,12,553};
		MergeSort2 ms = new MergeSort2();
		ms.sort(a1, 0, a1.length - 1);
		ms.sort(a2, 0, a2.length - 1);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));

	}
	
	public void sort(int[] A, int left, int right) {
		if (left < right) {
			int mid = (left + right)/2;
			sort(A, left, mid);
			sort(A, mid+1, right);
			merge(A, left, mid, right);
		}
	}
	
	private void merge(int[] A, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left, j = mid + 1, k = 0;
		while (i <= mid && j <= right) {
			if (A[i] <= A[j])
				temp[k++] = A[i++];
			else
				temp[k++] = A[j++];
		}
		while (i <= mid)
			temp[k++] = A[i++];
		while (j <= right)
			temp[k++] = A[j++];
		
		//copy into original array
		int n = 0;
		for (int m = left; m <= right; m++) {
			A[m] = temp[n];
			n++;
		}
	}

}
