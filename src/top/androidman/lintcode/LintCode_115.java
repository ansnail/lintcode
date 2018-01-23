package top.androidman.lintcode;

import java.util.Arrays;

public class LintCode_115 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] nums = { 
				{ 0, 0, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 }, 
				{ 1, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1 }, };
		System.out.println(uniquePathsWithObstaclesI(nums));
	}
	
	public static int uniquePathsWithObstaclesII(int[][] obstacleGrid) {
		// write your code here
		int rows = obstacleGrid.length;
		int columns = obstacleGrid[0].length;
		if (rows == 0 || columns==0) {
			return 0;
		}
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		int[] path = new int[columns];
		for (int i = 0; i < path.length; i++) {
				path[i] = 0;
		}
		path[0] = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (obstacleGrid[i][j] == 1) {
					path[j] = 0;
				} else if(j > 0){
					path[j] += path[j - 1];
				}
			}
			System.out.println(Arrays.toString(path));
		}
		return path[columns - 1];
	}

	public static int uniquePathsWithObstaclesI(int[][] obstacleGrid) {
		// write your code here
		int rows = obstacleGrid.length;
		int columns = obstacleGrid[0].length;
		int[] path = new int[columns];
		int tmp = rows;
		for (int i = 0; i < path.length; i++) {
			if (obstacleGrid[0][i] == 0) {
				path[i] = 1;
			} else {
				for (int j = i; j < path.length; j++) {
					path[j] = 0;
				}
				break;
			}
		}
		System.out.println(Arrays.toString(path));
		for (int i = 1; i < rows; i++) {
			if (obstacleGrid[i][0] == 1) {
				path[0] = 0;
				tmp = i;
			}
			if (i >= tmp) {
				path[0] = 0;
			}
			for (int j = 1; j < columns; j++) {
				if (obstacleGrid[i][j] == 0) {
					path[j] += path[j - 1];
				} else {
					path[j] = 0;
				}
			}
			System.out.println(Arrays.toString(path));
		}
		return path[columns - 1];
	}

}
