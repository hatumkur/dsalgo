package com.PIE.book;

public class CombinationString2 {

	public static void combine(String input) {
		char[] inputArr = input.toCharArray();
		StringBuilder output = new StringBuilder();
		
		doCombine(inputArr, output, inputArr.length, 0);
	}
	
	public static void doCombine(char[] input, StringBuilder output, int length, int start) {
		for(int i = start; i < length; i++) {
			output.append(input[i]);
			System.out.println(output.toString());
			doCombine(input, output, length, i+1);
			output.setLength(output.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		combine("abcd");
	}

}
