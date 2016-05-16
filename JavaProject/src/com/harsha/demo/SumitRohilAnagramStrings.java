package com.harsha.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
It's a fine sunny afternoon today in California. Looking at the pleasant weather, Sumit is all ready to go out and play with his friend Rohil. Unfortunately, Rohil is down with fever. Seeing that his friend is ill, Sumit decides not to go out - instead play with Rohil inside the house. Sumit loves math, on the contrary Rohil loves strings. Sumit decides to play a game that involves more of strings and less of Maths so that Rohil could be at ease and have fun playing it.

The game is simple and is played on a piece of paper. Sumit writes down a long list of names on that paper and passes it to Rohil. Rohil gets confused on seeing so many names on that paper and asks Sumit about the game. So, Sumit explains him the rules of the game. Rohil is supposed to partition the names into groups, such that:

    Each name belongs to exactly one group.
    Names that belong to the same group are pairwise anagrams.
    The first character of all the names in the same group are equal.
    The last character of all the names in the same group are equal.
    The number of groups is minimum possible.

Note: Two strings are called anagrams if it's possible to form one string from the other by changing the order of its characters.

Rohil would have won the game easily, if he would have been fit and fine but since he is ill right now he needs your help in winning the game. So, help out Rohil and do give him your blessings.

Input:
The first line contains a single integer N indicating the size of the list. This is followed by N lines where each line contains a name listed by Sumit.

Output:
In a single line print minimum number of groups in a partition that satisfy above conditions

Constraints:
1<= N <=100
1 <= Length of a name <= 100

All names will consist of lowercase English alphabets(a-z).
SAMPLE INPUT

6
vinay
vainy
vinit
viint
avinash
aasivnh

SAMPLE OUTPUT

3

Explanation

There are 3 special groups

1) vinay and vainy

2) vinit and viint

3) avinash and aavsinh

 */
public class SumitRohilAnagramStrings {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		String [] names = new String[N];
		int [] strsInEachGroup = new int[N];
		int [] groupIds = new int[N];
		int groupsCount = 0;
		int index = 0;
		while(index < N) {
			names[index++] = br.readLine();
		}
				
		for(int i = 0; i < N; i++) {
			int len1 = names[i].length();
			boolean found = false;
			for(int j = 1; j < N; j++) {
				if( groupIds[j] != 0) {
					continue;
				}
				int len2 = names[j].length();
				if(len1 == len2 && 
				   names[i].charAt(0) == names[j].charAt(0) &&
				   names[i].charAt(len1-1) == names[j].charAt(len2-1)) {
					char [] subchars1 = names[i].substring(1, len1 -1).toCharArray();
					Arrays.sort(subchars1);
					String sortedsubstr1 = new String(subchars1);
					char [] subchars2 = names[j].substring(1, len2 -1).toCharArray();
					Arrays.sort(subchars2);
				
					String sortedsubstr2 = new String(subchars2);					
					
					System.out.println(sortedsubstr1 + "  " + sortedsubstr2);
					if(sortedsubstr2.compareTo(sortedsubstr1) == 0) {
						strsInEachGroup[groupsCount]++;
						//System.out.println("anagram" + (groupsCount+1));
						groupIds[i] = groupIds[j] = groupsCount+1;
						
						if(!found) {
							found = true;
							groupsCount++;
						}
					}
				}

			}
			if(!found && groupIds[i] == 0) {
				groupsCount++;
			}
			found = false;
			
			//System.out.println("groups count" + groupsCount);
		}
		System.out.println("" + groupsCount);
	}

}
