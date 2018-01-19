package top.androidman.lintcode;

public class LintCode_28 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] nums = { { 1, 3, 5, 7 },
						 { 9, 11, 13, 15 }, 
						 { 17, 19, 21, 23 } };
		System.out.println(searchMatrix(nums, 29));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		// write your code here
		if(matrix == null || matrix.length == 0){
            return false;
        }
		int rows = matrix.length;
		int columns = matrix[0].length;
		for (int i = 0; i < rows; i++) {
			if (target <= matrix[i][columns - 1]) {
				for (int j = 0; j < columns; j++) {
					if (matrix[i][j] ==target) {
						return true;
					}
				}
				break;
			}
		}
		return false;
	}

}
