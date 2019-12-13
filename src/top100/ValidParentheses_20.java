package top100;

import java.util.Stack;

/**
 *
 * 验证是否是对称的字符串
 *
 * @author: Xiang Mingzhe
 * @version ValidParentheses_20.java, v 0.1 2019/12/13 16:59 XiangMingZhe Exp $
 **/
public class ValidParentheses_20 {


	/**
	 * 利用栈的特性 遇到开口符号入栈 遇到闭口符号判断栈顶是否匹配
	 * @param s
	 * @return
	 */
	private static boolean isValid(String s) {
		int length = s.length();
		if (length == 0) {
			return true;
		} else {
			if (length % 2 != 0) {
				return false;
			}
		}
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			switch (c) {
				case '(' :
					stack.push(')');
					break;
				case '{' :
					stack.push('}');
					break;
				case '[' :
					stack.push(']');
					break;
				default:
					if (stack.isEmpty() || stack.pop() != c) {
						return false;
					}
					break;
			}
		}
		return stack.isEmpty();

	}

	public static void main(String[] args) {
		System.out.println(isValid("([()])"));
	}
}
