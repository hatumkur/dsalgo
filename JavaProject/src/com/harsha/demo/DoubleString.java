package com.harsha.demo;

/*
Xsquare got bored playing with the arrays all the time. Therefore, he has decided to play with the strings. Xsquare called a string P a "double string" if string P is not empty and can be broken into two strings A and B such that A + B = P and A = B. for eg : strings like "baba" , "blabla" , "lolo" are all double strings whereas strings like "hacker" , "abc" , "earth" are not double strings at all.

Today, Xsquare has a special string S consisting of lower case English letters. He can remove as many characters ( possibly zero ) as he wants from his special string S. Xsquare wants to know , if its possible to convert his string S to a double string or not.

Help him in accomplishing this task.

Note :

Order of the characters left in the string is preserved even after deletion of some characters.

Input :

First line of input contains a single integer T denoting the number of test cases. First and the only line of each test case contains a string S denoting Xsquare's special string.
Output :

For each test case, print "Yes" if it is possible to convert the given string to a double string. Print "No" otherwise.
Constraints :

    1 ≤ T ≤ 100
    1 ≤ |S| ≤ 100
    String |S| consists of lower case english alphabets only.

Subtasks :

    Subtask 1 : 1 ≤ T ≤ 100 , 1 ≤ |S| ≤ 26 : ( 30 pts )
    Subtask 2 : 1 ≤ T ≤ 100 , 27 ≤ |S| ≤ 100 : ( 30 pts )
    Subtask 3 : 1 ≤ T ≤ 100 , 1 ≤ |S| ≤ 100 : ( 40 pts )

SAMPLE INPUT

5
wow
tata
a
ab
lala


SAMPLE OUTPUT

Yes
Yes
No
No
Yes


 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DoubleString {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		String[] lines = new String[N];
		for (int i = 0; i < N; i++) {
			lines[i] = br.readLine();
		}

		for (int i = 0; i < N; i++) {
			int lineLength = lines[i].length();
			boolean isDoubleStr = false;
			String str = lines[i];

			for (int j = 0; j < lineLength && isDoubleStr == false; j++) {
				for (int k = j+1; k < lineLength; k++) {
					String substr = str.substring(j, k);

					// Found twice ??
					int fIndex = str.indexOf(substr);
					if (fIndex != -1 && fIndex != lineLength-1) {
						fIndex = str.indexOf(substr, fIndex+1);
						if(fIndex != -1) {
							isDoubleStr = true;
							break;
						}
						
					}
				}
			}

			if (isDoubleStr) {
				isDoubleStr = false;
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

	}

}
