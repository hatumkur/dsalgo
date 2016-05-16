package com.harsha.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class CountingAlphabets {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toUpperCase();
        
        TreeMap<Character,Integer> map = new TreeMap<Character,Integer> ();
        
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            map.put(ch, 0);
        }
        
        for(int i = 0; i < line.length(); i++) {
        	char key = line.charAt(i);
        	if(map.containsKey(key)) {
        		int count = map.get(key);
        		count++;
        		map.put(key, count);
        	}
        }
        
        for(Character key : map.keySet()) {
        	System.out.print(map.get(key) + " ");
        }
	}

}

