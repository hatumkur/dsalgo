package com.harsha.demo;

/* IMPORTANT: Multiple classes and nested static classes are supported */
/*
ou are given two sorted arrays. Array A of size N and array B of size M.

Your task is to write a function which does the following:
- accept array A and array B
- create a new array of size N+M
- merge array A and array B in this newly created array such that the new array is also sorted
- returns this newly created array.

Now print the returned array to output.

Input:
First line of input contains N, size of array sorted A and second line contains N space separated elements of array A.
Third line of input contains M size of the sorted array B and fourth line contains M space separated elements of array B.

Output:
Your code should have a function that accepts arrays A and B, it should then merge these arrays in a new sorted array. Then the function should return the newly created array. Finally print the elements of merged sorted array separated by space.

Constraints:
1 ≤ N,M ≤ 1000000
0 ≤ Ai, Bi ≤ 1000000
Sample Input
(Plaintext Link)

10
1 2 2 3 4 6 6 8 9 10
5
1 2 2 2 3

Sample Output
(Plaintext Link)

1 1 2 2 2 2 2 3 3 4 6 6 8 9 10


 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


class ArrayMerge {
	static class MyIntegerComparable implements Comparator<Integer> {
		public int compare(Integer o1, Integer o2) {
			return (o1 > o2 ? -1 : (o1==o2 ? 0 : 1));
		}
	}
	
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String[] valuesN = br.readLine().split(" ");
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        
        for (int i = 0; i < N; i++) {
            array1.add(Integer.parseInt(valuesN[i]));
        }
        line = br.readLine();
        int M = Integer.parseInt(line);
        String[] valuesM = br.readLine().split(" ");        
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            array2.add(Integer.parseInt(valuesM[i]));
        } 

        array2.addAll(array1);
        
        /*array2.sort(new Comparator<Integer>() {
        	public int compare (Integer o1, Integer o2) {
        		return o1.compareTo(o2);
        	}
        }); */
        
        Collections.sort(array2, new MyIntegerComparable());
        
       /* Arrays.sort(array2.toArray(), new Comparator<Integer>() {
        	public int compare (Integer o1, Integer o2) {
        		return o1.compareTo(o2);
        	}
        });*/

        for (int i = 0; i < M+N; i++) {
        	System.out.print(array2.get(i) );
        	if(i < M + N) {
        		System.out.print(" ");
        	}
        }        
        
    }
}
