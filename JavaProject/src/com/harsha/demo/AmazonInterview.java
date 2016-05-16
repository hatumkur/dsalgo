package com.harsha.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Given that amazon wants to recruit only one from a group of n equally qualified candidates, 
they have decided to make them all stand in a row and them ask the ones standing at odd places 
to go home, repeatedly till one exists. Given n by standing at what position shall ensure a 
sure recruitment by Amazon.
Read more at http://pagesofflife.blogspot.com/2012/07/the-amazon-interview-process.html#w8fVRxr0QAWxEqv7.99
1      =>    1      
2      =>    2
3      =>    2
4      =>    4
5      =>    4
6      =>    4
7      =>    4
8      =>    8
9      =>    8
10    =>    8
15    =>    8
16    =>    16  

i = 0;
while(power(2,i) < N) {
	i++;
}    
 
 */
public class AmazonInterview {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of candidates in each Group : ");
		int N = Integer.parseInt(br.readLine());
		
		int power2 = 1;
		int position = 1;		
		while(N >= power2) {
			position = power2;
			power2 = power2 * 2;
		}
		
		System.out.printf(" Candidate Position to be lucky = %d",position);

	}

}
