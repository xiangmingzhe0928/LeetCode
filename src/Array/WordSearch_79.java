package Array;

/**
 * Array
 * description:
 * author:mingzhe Xiang
 * date:2016/11/21
 */
public class WordSearch_79 {

	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (exist(board, i, j, word, 0))
					return true;
			}
		}
		return false;
	}

	/**
	 * 回溯法-递归
	 * @param board
	 * @param x
	 * @param y
	 * @param word
	 * @param start
	 * @return
	 */
	private static boolean exist(char[][] board, int x, int y, String word, int start) {
		if (start >= word.length())
			return true;

		//边界控制
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return false;
		if (board[x][y] == word.charAt(start++)) {
			char c = board[x][y];
			board[x][y] = '#';
			//上下左右递归查找下一位
			boolean res = exist(board, x + 1, y, word, start) ||
				exist(board, x - 1, y, word, start) ||
				exist(board, x, y + 1, word, start) ||
				exist(board, x, y - 1, word, start);
			board[x][y] = c;
			return res;
		}
		return false;
	}
}
