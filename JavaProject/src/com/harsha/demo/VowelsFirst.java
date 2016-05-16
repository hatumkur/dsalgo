package com.harsha.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Given a linked list containing a sequence of characters, reorganise the string such that all the 
vowels appear first and the consonants next and they be sorted in the order they appeared.
Read more at http://pagesofflife.blogspot.com/2012/07/the-amazon-interview-process.html#w8fVRxr0QAWxEqv7.99
 */
public class VowelsFirst {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int substrlen = Integer.parseInt(br.readLine());
		
		if(str.length() >= substrlen) {
			
			/*ArrayList<String> substrArr = new ArrayList<String>();
			
			for(int i = 0; i <= str.length() - substrlen ; i++) {
				substrArr.add(str.substring(i,i+3));
			}
			
			Collections.sort(substrArr);
			
			System.out.println(substrArr.get(0));
			System.out.println(substrArr.get(substrArr.size()-1));
			*/
		}
		
	}
	
	

}
