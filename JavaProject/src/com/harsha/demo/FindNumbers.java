package com.harsha.demo;

/* IMPORTANT: Multiple classes and nested static classes are supported */



import java.util.Scanner;


class FindNumbers {
    public static void main(String args[] ) throws Exception {

        Scanner console = new Scanner(System.in);
        //System.out.println(console.nextLine());
        
        Scanner lineTokenizer = new Scanner(console.nextLine());
 
        //Integer.par
		//while(lineTokenizer.hasNextInt()) 
		{
			System.out.println(lineTokenizer.nextInt());
		}
		
       /* Scanner lineTokenizer;
        int lineNum = 0;
        
        while(console.hasNextLine()) {
        	lineTokenizer = new Scanner(console.nextLine());
        	lineNum++;

    		while(lineTokenizer.hasNextInt()) {
    			System.out.println(lineTokenizer.nextInt());
    		}

        }*/

        //System.out.println("Hello World!");
    }
}

