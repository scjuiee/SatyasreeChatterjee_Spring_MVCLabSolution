package com.greatlearning.iitr.fullstacklearning.dsasolution;

import java.util.Stack;

public class DetermineBalancedBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bracketStr = "([[{}]])";

		if (isBalancedBracket(bracketStr)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}

	/**
	 * This method is used to check the sequence and matching of two consecutive
	 * characters pushed and popped from stack and determine whether the bracket
	 * expression is balanced or unbalanced
	 * 
	 * @param bracketStr
	 * @return
	 */
	private static boolean isBalancedBracket(String bracketStr) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < bracketStr.length(); i++) {
			// c = String character at i - use charAt( i )
			Character c1 = bracketStr.charAt(i);

			// check if c1 is one of the opening brackets
			if (c1 == '{' || c1 == '[' || c1 == '(') {
				// stack.push(c1)
				stack.push(c1);
			} else {
				// else it is a closing bracket
				// if stack is empty (no corresponding opening bracket) -> not balanced
				if (stack.isEmpty()) {
					return false;
				}

				// c2 = stack.pop()
				Character c2 = (Character) stack.pop();
				// Compare between c1 and c2, if they are matched then it is balanced otherwise
				// not balanced
				if (c1 == '}' && c2 != '{' || c1 == ']' && c2 != '[' || c1 == ')' && c2 != '(') {
					return false;
				}
			}
		}

		// check if stack is empty -> if yes then balanced, else not balanced
		return stack.isEmpty();
	}

}
