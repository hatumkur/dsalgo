package com.harsha.temp;

import java.util.HashMap;

// Space complexity O(Total)
// Time complexity O(total * coins.length);
public class CoinDenomination {

	public int optimalCoinsCount(int total, int[] coins, HashMap<Integer,Integer> map){
		
		if(map.containsKey(total)) {
			return map.get(total);
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < coins.length; i++) {
			if(coins[i] > total) {
				continue;
			}
			
			int val = optimalCoinsCount(total - coins[i], coins, map);
			
			if(val < min) {
				min = val;
			}
		}
		
		min = (min == Integer.MAX_VALUE) ? min : min+1;
		
		map.put(total, min);
		
		return min;
	}
	public static void main(String[] args) {

	}

}
