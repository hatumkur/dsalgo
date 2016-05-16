package com.harsha.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
Alice is climbing stairs. There are total N stairs. She climbs A stairs upwards in day and she comes downstairs in night by B stairs. Find number of days she will take to reach the top of staircase.

Input:
First and only line contains three space separated integers denoting A, B, N.

Output:
Print only one line of output denoting the answer to the question.

Constraints:
1 ≤ B<A≤N ≤ 109
SAMPLE INPUT

5 1 6

SAMPLE OUTPUT

2
*/
public class ClimbingStairs {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStrs = buffReader.readLine().split(" ");
		int A = Integer.parseInt(inputStrs[0]);
		int B = Integer.parseInt(inputStrs[1]);	
		int N = Integer.parseInt(inputStrs[2]);		
		
		int totalStepsClimbed = 0, numberofDays = 0;
		
		while(totalStepsClimbed < N) {
			totalStepsClimbed += A;
			numberofDays++;
			if(totalStepsClimbed < N) {
				totalStepsClimbed -= B;
			}
		}
		System.out.println("" + numberofDays);
		
	}

}
