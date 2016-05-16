package Q16_05_Factorial_Zeros;

public class QuestionA {
	public static int factorsOf5(int i) {
		int count = 0;
		while (i % 5 == 0) {
			count++;
			i /= 5;
		}
		return count;
	}

	public static int countFactZeros(int num) {
		int count = 0;		
		for (int i = 2; i <= num; i++) {
			count += factorsOf5(i);
		}
		return count;
	}
/*

    51 :  4617 ÷ 5 = 923.4, so I get 923 factors of 5
    52 :  4617 ÷ 25 = 184.68, so I get 184 additional factors of 5
    53 :  4617 ÷ 125 = 36.936, so I get 36 additional factors of 5
    54 :  4617 ÷ 625 = 7.3872, so I get 7 additional factors of 5
    55 :  4617 ÷ 3125 = 1.47744, so I get 1 more factor of 5
    56 :  4617 ÷ 15625 = 0.295488, which is less than 1, so I stop here.

    Then 4617! has 923 + 184 + 36 + 7 + 1 = 1151 trailing zeroes.
	
 */
	public static int countFactZeros2(int num) {
		int count = 0;	
		for (int i = 1; i <= num; i++) {
			int temp = num / (int)Math.pow(5, i);
			if(temp < 1) break;
			count += temp;
		}
		return count;
	}	
	
	public static int factorial(int num) {
		if (num == 1) {
			return 1;
		} else if (num > 1) {
			return num * factorial(num - 1);
		} else {
			return -1; // Error
		}
	}
	
	public static void main(String[] args) {
		for (int i = 4617; i < 4618; i++) {
			System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros(i) + " zeros");
			System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros2(i) + " zeros");
		}
	}

}
