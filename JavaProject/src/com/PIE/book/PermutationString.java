package com.PIE.book;

public class PermutationString {
	
	public static void permute(String input) {
		char[] inputArr = input.toCharArray();
		StringBuilder output = new StringBuilder();
		boolean[] isUsed = new boolean[input.length()];
		
		doPermute(inputArr,output, isUsed, input.length(), 0);
	}
	
	private static void doPermute(char[] input, StringBuilder output, 
			boolean[] isUsed, int length, int level) {
		if(level == length) {
			System.out.println(output.toString());
			return;
		} 
		
		for(int i = 0; i < length; i++) {
			if(isUsed[i]) continue;
			
			output.append(input[i]);
			isUsed[i] = true;
			doPermute(input, output, isUsed, length, level+1);
			isUsed[i] = false;
			output.setLength(output.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		permute("abcd");
	}

}
