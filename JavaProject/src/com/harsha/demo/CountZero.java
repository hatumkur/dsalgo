package com.harsha.demo;

public class CountZero {

	static long zeroUpto(int digits)
	{
	    // Refer below article for details
	    // http://www.geeksforgeeks.org/count-positive-integers-0-digit/
	    int first = ((int)Math.pow(10,digits)-1)/9;
	    int second = ((int)Math.pow(9,digits)-1)/8;
	    return 9 * (first - second);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 8;
		/*int max = (int)Math.pow(10, input) - 1;

		int count = 0;
		StringBuilder strbld = new StringBuilder();
		for(int i = 1; i < max; i++){
			strbld.append(i);
			if(strbld.toString().contains("0")) {
				count++;
			}
			strbld.setLength(0);
		}
		//System.out.println("\n" + count); */
		System.out.println("\n" + zeroUpto(input));
	}

}
