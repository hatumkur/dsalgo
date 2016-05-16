package com.harsha.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class LongestAllUniqueLettersSubstring {

	public static String findLongestAllUniqueLettersSubstring(String input) {
		int startIndex = 0;
		int endIndex = 0;
		int maxLength = 0;
		int startIndexMax = 0;
		int endIndexMax = 0;
		int i = 0;
		char ch;

		HashSet<Character> set = new HashSet<Character>();
		
		i = 0;
		while (i < input.length()) {
			ch = input.charAt(i);
			if (!set.contains(ch)) {
				set.add(ch);
				endIndex = i;

			} else {

				if (maxLength < endIndex - startIndex) {
					maxLength = endIndex - startIndex;
					startIndexMax = startIndex;
					endIndexMax = endIndex;
				}
				// Reset the start & end
				startIndex = i;
				endIndex = i;
				set.clear();
			}
			i++;

		}

		System.out.printf("\n startIndexMax = %d endIndexMax = %d ",startIndexMax,endIndexMax);
		return input.substring(startIndexMax, endIndexMax);
	}

	public static void main(String[] args) throws Exception {
		
		System.out.println("Input a string : ---------------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		//str = "abcdaaabcdefaabefglaaa";

		System.out.printf("Longest All Unique Letter Substring of [%s] = ", str);
		System.out.println(findLongestAllUniqueLettersSubstring(str));
	}
}
