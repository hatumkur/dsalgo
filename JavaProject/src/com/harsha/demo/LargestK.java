package com.harsha.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 3 rd largest
public class LargestK {

	private static Integer largestK(Integer array[], int k, int arrayLen) {
		if(arrayLen < k) {
			return -1;
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		int i = 0;
		while (i < k) {
			queue.add(array[i]);
			i++;
		}
		for (; i < arrayLen; i++) {
			Integer value = queue.peek();
			if (array[i] > value) {
				queue.poll();
				queue.add(array[i]);
			}
		}
		
		return queue.peek();
	}

	private static PriorityQueue<Integer> createPriorityQueue(Integer array[], int k, int arrayLen) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		int i = 0;
		while (i < k) {
			queue.add(array[i]);
			i++;
		}
		for (; i < arrayLen; i++) {
			Integer value = queue.peek();
			if (array[i] > value) {
				queue.poll();
				queue.add(array[i]);
			}
		}
		
		return queue;
	}	
	
	public static void main(String[] args) throws Exception{
		//Integer array[] = new Integer[] { 3, 6, 2, 8, 9, 4, 5 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		String [] values = br.readLine().split(" ");
		Integer array[] = new Integer[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(values[i]);
		}
		
		for (int i = 0; i < array.length; i++) {

			int first = largestK(array, 1, i+1);
			int second = largestK(array, 2, i+1);
			int third = largestK(array, 3, i+1);

			if (first != -1 && second != -1 && third != -1) {
				System.out.println(first * second * third);
			} else {
				System.out.println(-1);
			}/*
			if(i < 2) {
				System.out.println(-1);
			} else {
				PriorityQueue<Integer> queue = createPriorityQueue(array, 3, i+1);
				
				System.out.println(queue.poll() * queue.poll() * queue.poll());
			}*/
		}

	}
}