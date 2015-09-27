package lsardana.algorithms.sorting;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] a1 = {100,44,99,2,7,1,9,1,8,3,0,2,8,3,8,5};
		int[] a2 = {5,8,7,6,4,9,8,6,7,5,3,2,1,2,3,4,34,12,553};
		ShellSort ss = new ShellSort();
		ss.sort(a1, a1.length);
		ss.sort(a2, a2.length);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));

	}
	
	public void sort(int[] A, int n) {
		for (int gap = n/2; gap > 0; gap = gap/2) {
			for (int i = gap; i < n; i += gap) {
				int value = A[i];
				int hole = i;
				while (hole >= gap && A[hole - gap] > value) {
					A[hole] = A[hole - gap];
					hole = hole - gap;
				}
				A[hole] = value;
			}
		}
	}

}
