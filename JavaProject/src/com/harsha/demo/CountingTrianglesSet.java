package com.harsha.demo;
/*
You are given n triangles.

You are required to find how many triangles are unique out of given triangles. For each triangle you are given three integers a,b,c , the sides of a triangle.

A triangle is said to be unique if there is no other triangle with same set of sides.

Note : It is always possible to form triangle with given sides.

INPUT:

First line contains n, the number of triangles. Each of next n lines contain three integers a,b,c (sides of a triangle).

Output:

print single integer, the number of unique triangles.

Constraints:

1 <= n <= 10^5
1 <= a,b,c <= 10^15
SAMPLE INPUT

5
7 6 5
5 7 6
8 2 9
2 3 4
2 4 3 

SAMPLE OUTPUT

1


 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class CountingTrianglesSet {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);

		List<TreeSet<Integer>> sets = new ArrayList<TreeSet<Integer>>();

		for (int i = 0; i < N; i++) {
			TreeSet<Integer> trset = new TreeSet<Integer>();
			int v1, v2, v3;
			String[] str = br.readLine().split(" ");
			v1 = Integer.parseInt(str[0]);
			v2 = Integer.parseInt(str[1]);
			v3 = Integer.parseInt(str[2]);

			trset.add(v1);
			trset.add(v2);
			trset.add(v3);
			sets.add(trset);
		}

		int unqCount = 0;
		for (int i = 0; i < N; i++) {

			TreeSet<Integer> set = sets.get(i);
			boolean unique = true;

			for (int j = 0; j < N; j++) {

				// if(i == j ) continue;

				TreeSet<Integer> set2 = sets.get(j);
				if (i != j) {
					if (set.containsAll(set2)) {
						unique = false;
					} else {
						unique = true;
					}
				}
				if (j == N - 1 && unique == true) {
					unqCount++;
				}

				if (unique == false) {
					break;
				}
			}

		}
		System.out.println(unqCount);
	}
}
