package top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses_22 {

	/**
	 * 原则上一个位置能放"("、")"两种字符. 但若已经存在count('(') == count(')')则不能在存放')'
	 * @param n
	 * @return
	 */
	private static List<String> generateParenthesis(int n) {

		List<String> res = new ArrayList<>();
		generate(res, 0, 0, n, "");

		return res;
	}

	private static void generate(List<String> res, int leftCount, int rightCount, int n, String item) {
		if (leftCount < rightCount || leftCount > n) {
			return;
		}

		if (leftCount == n && rightCount == n) {
			res.add(item);
			return;
		}

		generate(res, leftCount + 1, rightCount, n, item + "(");
		generate(res, leftCount, rightCount + 1, n, item + ")");

	}

	//=============================================================

//	private static List<String> generateParenthesisWithQueue(int n) {
//		Map<String, Integer> preMapping = new HashMap<>(2);
//		LinkedList<String> queue = new LinkedList<>();
//		String temp = "(";
//		queue.addLast(temp);
//		preMapping.put(temp, 1);
//		for (int i = 1; i <= 2*n ; i++) {
//			while (queue.peek().length() < i) {
//				temp = queue.pop();
//				int needR = preMapping.get(temp);
//				if (needR > 0) {
//					preMapping.remove(temp);
//					preMapping.put(temp + ")", needR - 1);
//					queue.addLast(temp + ")");
//				}
//				if (i != 2*n) {
//					preMapping.remove(temp);
//					preMapping.put(temp + "(", needR + 1);
//					queue.addLast(temp + "(");
//				}
//			}
//		}
////		List<String> res = new ArrayList<>();
////		generate(res, 0, 0, n, "");
//
//		return queue;
//	}



	public static void main(String[] args) {
		System.out.println(generateParenthesis(4));
//		System.out.println(generateParenthesisWithQueue(3));
	}
}