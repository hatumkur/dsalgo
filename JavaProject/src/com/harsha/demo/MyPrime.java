package com.harsha.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Recently you invented a brand-new definition of prime numbers. For a given set of positive integers 
S let's call X a prime if there are no elements in S which are divisors of X (except X itself).

You are given a set S. Find elements in it which are prime numbers for this set.

Input
The first line contains one integer N - size of the set S. The second line contains N space-separated integers - elements of S. All the numbers are pairwise different.

Output
Output one line: elements of S which are prime numbers for this set in the order they occur in the input. Separate them by whitespaces.

Constraints

    N <= 100
    1 <= S[i] <= 106 (1<=i<=n)

SAMPLE INPUT

5
10 5 3 15 16

SAMPLE OUTPUT

 5 3 16
*/
public class MyPrime {
	
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String[] setline = br.readLine().split(" ");
        
        int [] set = new int[N];
        for (int i = 0; i < N; i++) {
            //System.out.println("hello world");
        	set[i] = Integer.parseInt(setline[i]);
        }
        
        for(int i = 0; i < N; i++) {
        	boolean isMyPrime = true;
        	for(int j = 0; j < N; j++) {
        		if(i != j && set[i] % set[j] == 0) {
        			isMyPrime = false;
        			break;
        		}
        	}
        	if(isMyPrime) {
        		System.out.print("" + set[i] + " ");
        		isMyPrime = false;
        	}
        }
        

        //System.out.println("Hello World!");
    }
}
