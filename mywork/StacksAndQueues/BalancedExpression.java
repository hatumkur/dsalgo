/*
 (){}[]
 Rule: Last unclosed should be closed first
*/
/*
 * (1) If openening parenthesis push to stack
 * (2) If closing parenthesis pop, compare failure => NB otherwise loop till end
 * (3) End stack is non empty => NB otherwise => B
 *
 */

public boolean isValid(String inputStr) {

	char[] input = inputStr.toCharArray();
	LinkedList<Character> stack = new LinkedList<Character>();

	for(int i = 0; i < input.length; i++) {
		if(isOpenParenthesis(input[i])) {
			stack2.push(input[i]);
		} else {
			if(stack.isEmpty()) return false;
			char temp = stack.pop();
			if(!isMatchingParenthesis(input[i], temp)) return false;
		}
	}

	if(!s.isEmpty()) return false;

	return true;
}

public boolean isOpenParenthesis(char ch) {
	return (ch == '(' || ch == '[' || ch == '{');
}

public boolean isMatchingParenthesis(char ch1, char ch2) {
	return (    (ch1 == '(' && ch2 == ')')
			 || (ch2 == '(' && ch1 == ')')
			 || (ch1 == '[' && ch2 == ']')
			 || (ch2 == '[' && ch1 == ']')
			 || (ch1 == '{' && ch2 == '}')
			 || (ch2 == '{' && ch1 == '}') );

}
