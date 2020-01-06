package top100;

/**
 *
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * @author: Xiang Mingzhe
 * @version WordSearch_79.java, v 0.1 2020/1/3 11:07 XiangMingZhe Exp $
 **/
public class WordSearch_79 {

	public static boolean exist(char[][] board, String word) {
		if (board.length == 0 || word.length() == 0) {
			return false;
		}
		boolean[][] visitor = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (braceTrace(0, board, i,j, word, visitor)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 回溯
	 *
	 * @param targetCharIndex 当前需要匹配的字符
	 * @param board
	 * @param m 当前扫描的2D-board 行index
	 * @param n 当前扫描的2D-board 列index
	 * @param word 目标字符串
	 * @param visitor 是否扫描过标记
	 * @return
	 */
	private static boolean braceTrace(int targetCharIndex, char[][] board, int m, int n, String word, boolean[][] visitor) {
		if (m >= board.length || n >= board[0].length || m < 0 || n < 0) {
			return false;
		}
		if (visitor[m][n]) {
			return false;
		}
		if (targetCharIndex + 1 == word.length() && board[m][n] == word.charAt(targetCharIndex)) {
			return true;
		}
		if (board[m][n] == word.charAt(targetCharIndex)) {
			visitor[m][n] = true;

			// 递归向周边格子扫描
			boolean exist =  braceTrace(targetCharIndex + 1, board, m - 1, n, word, visitor) ||
				braceTrace(targetCharIndex + 1, board, m, n - 1, word,visitor) ||
				braceTrace(targetCharIndex + 1, board, m, n + 1, word,visitor) ||
				braceTrace(targetCharIndex + 1, board, m + 1, n, word,visitor);

			if (!exist) {
				visitor[m][n] = false;
			}
			return exist;


		}
		return false;
	}

	public static void main(String[] args) {
//		[["C","A","A"],["A","A","A"],["B","C","D"]]
//		"AAB"
		char[][] board = new char[][]{{'C','A','A'},
									  {'A','A','A'},
									  {'B','C','D'}};
		System.out.println(exist(board,"AAB"));
	}
}
