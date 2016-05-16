package com.harsha.demo;

import java.util.LinkedHashMap;

public class LinkedHashmapDemo {
	
	public static void main(String [] args){
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		map.put('a', 1);
		map.put('n',1);
		
		//Character non-repeating-chr = '';
		for(Character key : map.keySet()) {
			if(map.get(key) == 1) {
				// return key;
			}
		}
	}

}
