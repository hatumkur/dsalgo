
package com.harsha.demo;


public class StringsDemo {

	public static void main(String args[]){
		String str = "Hello World";
		System.out.println("Str len = " + str.length());
		
		String s = String.format("%s", str);
		System.out.println(s);
		System.out.println(s.substring(2, s.length()-1));
		System.out.println(str.toLowerCase());
		
		StringBuffer strBuf = new StringBuffer(10);
		strBuf.append(10);
		strBuf.append(str);
		System.out.println(strBuf.charAt(5));
		strBuf.ensureCapacity(20);
		
		StringBuilder strBld = new StringBuilder(20);
		strBld.append(str);
		strBld.append("StringBuilder");
		System.out.println(strBld);
		str.compareTo(strBld.toString());
		
		strBld.reverse();
		strBld.deleteCharAt(2);
		
		

	}
}
