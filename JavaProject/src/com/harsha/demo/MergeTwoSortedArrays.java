package com.harsha.demo;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void mergeSortTwoArrays(int[] A, int[] B) {
		int la = A.length;
		int lb = B.length;
		//int j = lb - 1;
		
		for(int i = la - 1; i >= 0; i--) {
			
			for(int j = lb-1; j >= 0; j--) {
				if(A[i] < B[j]) { // B[j] is already at right place
					lb--;
					continue;
					//break;
				} else if(A[i] > B[j]){
					int temp = B[j];
					B[j] = A[i];
					A[i] = temp;
				}
			}
			
		}
		
		Arrays.sort(A);
	}
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}
	public static void main(String[] args) {
		int[] A = {1, 3, 5, 8, 10};
		int[] B = {2, 4, 7, 9, 12, 15};
		
		mergeSortTwoArrays(A, B);
		System.out.println("A: --------");
		printArray(A);
		System.out.println();
		System.out.println("B: --------");
		printArray(B);
		
	}
}
