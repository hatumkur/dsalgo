package com.PIE.book;

import java.util.LinkedList;

public class GenerateAllValidParenthesis {
	
	public static void permute(String input) {
		char[] inputArr = input.toCharArray();
		StringBuilder output = new StringBuilder();
		boolean[] isUsed = new boolean[input.length()];
		
		doPermute(inputArr,output, isUsed, input.length(), 0);
	}
	
	private static void doPermute(char[] input, StringBuilder output, 
			boolean[] isUsed, int length, int level) {
		if(level == length) {
			if(isValid(output.toString())) {
				System.out.println(output.toString());
			}
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
	
	private static boolean isValid(String inputStr) {
		
		char[] input = inputStr.toCharArray();
		LinkedList<Character> s = new LinkedList<Character>();
		
		for(int i = 0; i < input.length; i++) {
			if(input[i] == '(') {
				s.push(input[i]);
			} else {
				if(s.isEmpty()) return false;
				char temp = s.pop();
				if(temp != '(' /*MATCHING FOR ')'*/) return false;
			}
		}
		
		if(!s.isEmpty()) return false;
		
		return true;
	}
	
	private static String getBaseString(int length) {
		StringBuilder output = new StringBuilder();
		for(int i = 0; i < length; i++) {
			output.append("()");
		}
		return output.toString();
	}
	
	public static void main(String[] args) {
		int[] inputLenArr = {1, 2, 3};
		
		// For each input
		for(int i = 0; i < inputLenArr.length; i++) {
			System.out.println("========================================" + inputLenArr[i] + "=========================================" );
			String bs = getBaseString(inputLenArr[i]);
			permute(bs);
		}
	}

}
