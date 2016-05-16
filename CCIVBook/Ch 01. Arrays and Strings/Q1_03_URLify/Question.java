package Q1_03_URLify;

import CtCILibrary.AssortedMethods;

public class Question {
	// Assume string has sufficient free space at the end
/*	public static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, i = 0;
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		if (trueLength < str.length) str[trueLength] = '\0';
		for (i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	} */
	
	public static char[] replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0;
		for(int i = 0; i < trueLength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		
		int targetLength = trueLength + spaceCount * 2; //  ' '  => "%20"
		char[] result = null;
		if(targetLength > str.length) {
			result = new char[targetLength];
			
			for(int i = 0; i < trueLength; i++) {
				result[i] = str[i];
			}
			result[trueLength] = '\0';
		} else {
			result = str;
		}
		
		int index = targetLength - 1;
		for(int i = trueLength - 1;  i >= 0; i-- ) {
			if(result[i] == ' ') {
				result[index] = '0'; // 0
				result[index-1] = '2'; // 2
				result[index-2] = '%'; // %
				index = index - 3;
			} else {
				result[index] = result[i];
				index--;
			} 
		}
		
		System.out.println(result);
		return result;
	}
	
	
	public static int findLastCharacter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String str = "Mr John Smith ";
		char[] arr = str.toCharArray();
		int trueLength = findLastCharacter(arr) + 1;
		arr = replaceSpaces(arr, trueLength);	
		System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
		
		//String s = "Mr John Smith    ";
		str = str.trim();
		str = str.replaceAll(" ", "%20"); // str = str.replaceAll("\\s", "%20");
		System.out.println(str);
	}
}
