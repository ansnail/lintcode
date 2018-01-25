package top.androidman.lintcode;

public class LintCode_110 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] nums = { 
				{ 2, 3, 5, 2 }, 
				{ 7, 2, 3, 4 }, 
				{ 1, 6, 5, 7 },
				{ 4, 1, 8, 3 } };
		System.out.println(minPathSum(nums));
	}

	public static int minPathSum(int[][] grid) {
		// write your code here
		int columns = grid[0].length;
		int[] pathSums = new int[columns];
		pathSums[0] = grid[0][0];
		for (int i = 1; i < columns; i++) {
			pathSums[i] = pathSums[i - 1] + grid[0][i];
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 0; j < columns; j++) {
				if (j == 0) {
					pathSums[j] += grid[i][j];
				} else {
					pathSums[j] = Math.min(pathSums[j], pathSums[j-1]) + grid[i][j];
				}
			}
		}
		return pathSums[columns - 1];
	}

}
