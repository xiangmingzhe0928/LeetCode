package String;

/**
 Given a 2D board and a word, find if the word exists in the grid.
 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 For example,
 Given board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false

 * author:mingzhe Xiang
 * date:2018/3/26
 */
public class WordSearch_79 {

	public static boolean exist(char[][] board, String word) {
		if (board.length == 0)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, i, j, word, 0))
					return true;
			}
		}
		return false;
	}

	/**
	 * 典型的DFS
	 * @param board
	 * @param i
	 * @param j
	 * @param word
	 * @param wordIndex 当前轮需要匹配的word的index
	 * @return
	 */
	private static boolean dfs(char[][] board, int i, int j, String word, int wordIndex) {
		if (wordIndex == word.length())
			return true; //匹配完成
		if (i < 0
			|| i >= board.length
			|| j < 0
			|| j >= board[0].length
			|| board[i][j] != word.charAt(wordIndex))
			return false;

		// 题目要求一个元素只能被使用一次同时避免循环search,因此需标记已经访问过的元素
		// 此处最初用的特殊字符mark 后来leetCode上有人提醒 XOR操作
		board[i][j] ^= 256;
		boolean res = dfs(board, i - 1, j, word, wordIndex + 1)
			|| dfs(board, i + 1, j, word, wordIndex + 1)
			|| dfs(board, i, j - 1, word, wordIndex + 1)
			|| dfs(board, i, j + 1, word, wordIndex + 1);
		// 元素还原
		board[i][j] ^= 256;
		return res;
	}

	public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
		String wordTrue = "SEE";
		String wordFalse = "ABCB";
		System.out.println(exist(board, wordTrue));
		System.out.println(exist(board, wordFalse));
	}
}
