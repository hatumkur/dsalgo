package com.harsha.practice.stack;

import java.util.LinkedList;
/*
 * (1) If openening parenthesis push to stack
 * (2) If closing parenthesis pop, compare failure => NB otherwise loop till end
 * (3) End stack is non empty => NB otherwise => B
 *
 */
public class BalancedParenthesis {

	public static boolean isValid(String inputStr) {
		
		char[] input = inputStr.toCharArray();
		LinkedList<Character> s = new LinkedList<Character>();
		
		for(int i = 0; i < input.length; i++) {
			if(isOpenParenthesis(input[i])) {
				s.push(input[i]);
			} else {
				if(s.isEmpty()) return false;
				char temp = s.pop();
				if(!isMatchingParenthesis(input[i], temp)) return false;
			}
		}
		
		if(!s.isEmpty()) return false;
		
		return true;
	}
	
	public static boolean isOpenParenthesis(char ch) {
		return (ch == '(' || ch == '[' || ch == '{');
	}
	
	public static boolean isMatchingParenthesis(char ch1, char ch2) {
		return (    (ch1 == '(' && ch2 == ')')
				 || (ch2 == '(' && ch1 == ')') 
				 || (ch1 == '[' && ch2 == ']')
				 || (ch2 == '[' && ch1 == ']') 
				 || (ch1 == '{' && ch2 == '}')
				 || (ch2 == '{' && ch1 == '}') );
		
	}
	
	public static void main(String[] args) {

		String[] input = { "(()()())()()", "(()()())(}()", "(()()()){()}()", "()()()" };
		
		for(int i = 0; i < input.length; i++) {
			System.out.println("ISBALANCED: " + input[i] + "  " + isValid(input[i]));
		}
	}

}
