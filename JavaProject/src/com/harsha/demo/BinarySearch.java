package com.harsha.demo;

public class BinarySearch {

	static int binarySearchIterative(int[] arr, int l, int h, int x) {
		int mid = 0; 
		
		if(x > arr[h] || x < arr[l] ) return -1;
		
		while(l <= h) {
			mid = l + (h - l)/2;
			
			if(arr[mid] == x) return mid;
			
			if(arr[mid] > x) {
				h = mid;
			}
			
			if(arr[mid] < x) {
				l = mid;
			}
		}
		
		return -1;
	}
	
	static int binarySearchRecurr(int[] arr, int l, int h, int x) {
		int mid;
		
		if(x > arr[h] || x < arr[l] ) return -1;
		
		mid = l + (h - l)/2;
		
		if(arr[mid] == x) return mid;
		
		if(arr[mid] < x) {
			return binarySearchRecurr(arr, mid, h, x);
		}
		
		return binarySearchRecurr(arr, l, mid, x);
	}
	
	static int min (int x , int y) {
		return (x < y) ? x : y;
	}
    
	static int findMinBinarySearchRotated(int[] arr, int l, int h) {
		
		// This condition is needed to handle the case when array is not rotated at all
		if(h < l) return arr[0];

		// If there is only one element left to search
		if(h == l) return arr[l];
		
		int mid = l + (h - l)/2;		
		
        // Check if element (mid+1) is minimum element. Consider
        // the cases like {1, 1, 0, 1}
        if (mid < h && arr[mid+1] < arr[mid])  return arr[mid+1];
        
        // To handle repetition values : this case make O(n)
        if (arr[l] == arr[mid] && arr[h] == arr[mid]) {
            return min(findMinBinarySearchRotated(arr, l, mid-1),
            		findMinBinarySearchRotated(arr, mid+1, h));    
        }
        
		// Check if mid itself is minimum element
		if(mid > l && arr[mid] < arr[mid-1]) return arr[mid];
		
		if(arr[mid] < arr[h]) {
			return findMinBinarySearchRotated(arr, mid-1, h);
		} else {	
		return findMinBinarySearchRotated(arr, l, mid+1);
		}
	}
	
	public static void main(String[] args) {
		int [] array1 = new int[] {10, 20 ,30 ,50 ,80, 90 , 100};
		int foundIndex = binarySearchIterative(array1, 0, array1.length-1, 90);
		System.out.println("ITERATIVE: Location of the searched item is:  " + foundIndex );
		foundIndex = binarySearchRecurr(array1, 0, array1.length-1, 90);
		System.out.println("RECURSIVE: Location of the searched item is:  " + foundIndex );
		
		int [] array2 = new int[] {10, 10 ,10 ,10 ,20, 20 , 20};
		foundIndex = binarySearchIterative(array2, 0, array2.length-1, 20);		
		System.out.println("ITERATIVE: Location of the searched item is:  " + foundIndex );
		foundIndex = binarySearchIterative(array2, 0, array2.length-1, 90);
		System.out.println("ITERATIVE: Location of the searched item is:  " + foundIndex );
		foundIndex = binarySearchRecurr(array2, 0, array2.length-1, 20);		
		System.out.println("RECURSIVE: Location of the searched item is:  " + foundIndex );		
		foundIndex = binarySearchRecurr(array2, 0, array2.length-1, 90);
		System.out.println("RECURSIVE: Location of the searched item is:  " + foundIndex );		
		
		
		// Rotated sorted array
		int [] array3 = new int[] {7, 8, 9, 1, 2, 3, 4, 5};
		foundIndex = findMinBinarySearchRotated(array3, 0, array3.length-1);		
		System.out.println("Location of the searched item is:  " + foundIndex );
		
		//int [] array4 = new int[] {7, 8, 9, 1, 1, 1, 2, 2, 2, 3, 4, 5};
		//foundIndex = findMinBinarySearchRotated(array3, 0, array4.length-1);		
		//System.out.println("Location of the searched item is:  " + foundIndex );		
	}

}
