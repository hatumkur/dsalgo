package com.harsha.demo;
/*
Write a program to find the mode of a given list of integers. Mode of a number is defined as the number which is most frequently occured.
For example:
L = {1,2,2,3} // Here mode is 2(most frequently occured)

It is possible that multiple answers are possible for a list. In that case print all possible answers in non-increasing order.

Input:
First Line of input contains an integer t represeting the number of test cases, Where first line of each test case has an integers N - number of integers in list, Next line contains N integers.

Output:
print all the possible modes in non-increasing order.

Constraints:
1<=t<=100
1<=N<100000
1<=a[i]<=1000000
SAMPLE INPUT

2
5
1 2 2 2 2 
6
1 2 2 3 3 4

SAMPLE OUTPUT

2 
3 2 

 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FindMode {
	
	static int getFrequency(TreeMap<Integer,Integer> map) {
    	int count = 1; 
    	for(Integer key : map.keySet()) {
    		int val = map.get(key);
    		count = (val > count) ? val : count; 
    	}
    	
    	return count;
	}

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        int [][] arr2d = new int[T][];
        
        for(int testindex = 0; testindex < T; testindex++) {
        	line = br.readLine();
        	int N = Integer.parseInt(line);
        	arr2d[testindex] = new int[N];
        	String[] values = br.readLine().split(" ");
        	for(int i = 0; i < N ; i++) {
        		arr2d[testindex][i] = Integer.parseInt(values[i]);
        	}
        }

        List<TreeMap<Integer , Integer>> mapList  = new ArrayList<TreeMap<Integer,Integer>>();
        
        for(int i = 0; i < T; i++) {
        	TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();        	
        	for(int j = 0; j < arr2d[i].length; j++) {
        		if(!map.containsKey(arr2d[i][j])) {
        			map.put(arr2d[i][j], 1);
        		} else {
        			int count = map.get(arr2d[i][j]);
        			map.put(arr2d[i][j], count+1);
        		}
        	}
        	mapList.add(map);
        }
        
        for(int i = 0; i < T; i++) {
        	TreeMap<Integer,Integer> map = mapList.get(i);
        	int freq = getFrequency(map);
        	
        	for(Integer key : map.descendingKeySet()) {
        		int val = map.get(key);
        		if(val == freq) {
        			System.out.print("" + key + " ") ; 
        		}
        	}
        	System.out.print("\n");
        }
        //System.out.println("Hello World!");
    }

}
