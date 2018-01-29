package HashTable;

/**
 * HashTable
 * description:在一个2纬矩阵中 1代表陆地 0代表水域 求得陆地的周长
 You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally).
 The grid is completely surrounded by water,
 and there is exactly one island (i.e., one or more connected land cells).
 The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 例：
 [
 [0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]
 ]====》周长16

 * author:mingzhe Xiang
 * date:2017/1/17
 */
public class IslandPerimeter_436 {

	/**
	 * 遍历数组
	 * 每2个相邻陆地会减少2条重合边即周长-2
	 * @param grid
	 * @return
	 */
	public static int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0)
					continue;
				perimeter += 4;
				//相邻右元素为陆地
				if (i < grid.length - 1 && grid[i + 1][j] == 1)
					perimeter -= 2;
				//相邻下边元素为陆地
				if (j < grid[0].length - 1 && grid[i][j + 1] == 1)
					perimeter -= 2;
			}
		}
		return perimeter;
	}

	public static void main(String[] args) {
		System.out.println(islandPerimeter(new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
	}
}
