package Q1_06_String_Compression;

public class QuestionB {	
	public static String compress(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If next character is different than current, append this char to result.*/
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		System.out.println(compressed.toString());
		return compressed.length() <= str.length() ? compressed.toString() : str;
	}
	
	public static String compress2(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for(int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			if(i+1 == str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressed.append(str.charAt(i));
				//if(countConsecutive > 1) 
				{
					compressed.append(countConsecutive);
				}
				countConsecutive = 0;
			}
		}
		return compressed.length() <= str.length() ?  compressed.toString() : str;
	}
	
	public static void main(String[] args) {
		String[] strs = { "abcd" , "ab", "abbbcccccddddddd", "ccc ", "   aaabb  " };
		for(String str : strs ) {
			System.out.println(str);
			System.out.println(compress2(str));
		}
	}
}
