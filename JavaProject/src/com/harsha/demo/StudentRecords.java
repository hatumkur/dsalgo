package com.harsha.demo;

import java.util.Scanner;

/*
A file contains data as follows( Student name, marks in 3 subjects)
Shrikanth 20 50 60
Kiran 30 80 90
Find the student who has maximum average score.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the number of student.
The second line of each test case contains N input Student name and marks in 3 subject.

Output:

Print the student who has maximum average score and maximum average score(in int).

Constraints:

1 ≤ T ≤ 10
1 ≤ N ≤ 15
1 ≤ s ≤ 10
1 ≤ marks ≤ 100

Example:

Input:
2
2
Shrikanth 20 30 10 Ram 100 50 10
3
Adam 50 10 40 Suresh 22 1 56 Rocky 100 90 10

Output:
Ram 53
Rocky 66
 
**For More Examples Use Expected Output**
 */
class Student {
	String name;
	int marks[];
	int avg;

	Student(String name, int[] marks) {
		this.name = name;
		this.marks = marks;
		this.avg = (marks[0] + marks[1] + marks[2]) / 3;
	}
}

public class StudentRecords {

	public void printMaxAverage(Student[] students) {
		int bestIndex = 0;
		for(int i = 0; i < students.length; i++) {
			for(int j = 1; j < students.length; j++) {
				if(students[j].avg > students[i].avg) {
					bestIndex = j;
				}
			}
		}
		System.out.println(students[bestIndex].name + " " + students[bestIndex].avg);
	}

	public static void main (String[] args) {
			//code
		StudentRecords sr = new StudentRecords();
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int recordCount;
		int marks[] = new int[3];
		String name;
		Student[] students = null;
		
		for(int i = 0; i < T; i++) {
			recordCount = scanner.nextInt();
			students = new Student[recordCount];
			for(int j = 0; j < recordCount; j++) {
				name = scanner.next();
				marks[0] = scanner.nextInt();
				marks[1] = scanner.nextInt();
				marks[2] = scanner.nextInt();
				students[j] = new Student(name, marks);
			}
			sr.printMaxAverage(students);
		}
		scanner.close();
	}

}
// 15 => { 2 3 5 7 11 13 } { 2 3 5 7 11 13 } 
// 2 2 2 3 2 5 3 2 3 3 3 5 7 2  
