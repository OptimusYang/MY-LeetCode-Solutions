package tim.d2015092501.validparentheses;

import java.util.Stack;

public class Solution {
	/**
	 * Valid Parentheses
	 * 
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 * 
	 * https://leetcode.com/problems/valid-parentheses/
	 * 
	 * @author Tim
	 */
	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		if (s.length() == 1) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		char[] sc = s.toCharArray();
		boolean valid = true;
		for (char c : sc) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
			if (c == ')') {
				if (stack.isEmpty()) {
					valid = false;
					break;
				}
				char cpop = stack.pop();
				if (cpop != '(') {
					valid = false;
					break;
				}
			}
			if (c == ']') {
				if (stack.isEmpty()) {
					valid = false;
					break;
				}
				char cpop = stack.pop();
				if (cpop != '[') {
					valid = false;
					break;
				}
			}
			if (c == '}') {
				if (stack.isEmpty()) {
					valid = false;
					break;
				}
				char cpop = stack.pop();
				if (cpop != '{') {
					valid = false;
					break;
				}
			}
		}
		if (!stack.isEmpty()) {
			valid = false;
		}
		return valid;
	}

	public static void main(String[] args) {
		System.out.println(isValid("(("));

	}

}
