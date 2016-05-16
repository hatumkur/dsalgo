package com.harsha.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 http://www.purplemath.com/modules/factzero.htm
 
 
 Find number of trailing zeroes of factorial of a number
 
 Input:
 10
 
 Output:
 2
 
1 <=  N <= 1000
 
 */

class TrailingZeroes {
	
	
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
		*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter N : ");
        String line = br.readLine();
        int N = Integer.parseInt(line);
		int trzeroes = 0;
		int factor = 5;
		int temp = 0;
        for (int i = 0; i < N; i++) {
            //System.out.println("hello world");
        	temp = N / (int) Math.pow(factor, i+1);
        	if(temp > 0) {
        		trzeroes += temp; 
        	} else {
        		break;
        	}
            
        }
        
        System.out.println(""+ trzeroes);
    }
}