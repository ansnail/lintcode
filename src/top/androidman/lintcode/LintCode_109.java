package top.androidman.lintcode;

public class LintCode_109 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] nums = { { -1 }, { 2, 3 }, { 1, -1, -3 } };
		int[][] tmp = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		System.out.println(minimumTotalI(nums));
	}

	/**
	 * 时间复杂度(m*n) 空间复杂度O(n)
	 * @param triangle
	 * @return
	 */
	public static int minimumTotalI(int[][] triangle) {
		// write your code here
		int min = Integer.MAX_VALUE;
		int[] steps = new int[triangle.length];
		steps[0] = triangle[0][0];
		if (triangle.length == 1) {
			return triangle[0][0];
		} else {
			for (int i = 1; i < steps.length; i++) {
				for (int j = triangle[i].length -1; j >=0 ; j--) {
					if (j == 0) {
						steps[j] += triangle[i][j];
					} else if (j == triangle[i].length - 1) {
						steps[j] = triangle[i][j] + steps[j-1];
					} else {
						steps[j] = Math.min(steps[j], steps[j-1]) + triangle[i][j];
					}
					if (i == triangle.length -1 && steps[j] < min) {
						min = steps[j];
					}
				}
			}
		}
		return min;
	}

	
	/**
	 * 时间复杂度(m*n) 空间复杂度O(m*n)
	 * @param triangle
	 * @return
	 */
	public static int minimumTotalII(int[][] triangle) {
		if (null == triangle)
			return 0;
		int row = triangle.length;
		if (row <= 0)
			return 0;
		int[][] steps = new int[row][row];
		int min = Integer.MAX_VALUE;
		steps[0][0] = triangle[0][0];
		if (row == 1)
			return steps[0][0];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					steps[i][j] = steps[i - 1][j] + triangle[i][j];
				} else if (j == i) {
					steps[i][j] = steps[i - 1][j - 1] + triangle[i][j];
				} else {
					steps[i][j] = Math
							.min(steps[i - 1][j], steps[i - 1][j - 1])
							+ triangle[i][j];
				}

				if ((i == row - 1) && (steps[i][j] < min)) {
					min = steps[i][j];
				}
			}
		}
		return min;

	}

}
