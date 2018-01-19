package top.androidman.lintcode;


/**
 * 这个解法最巧妙的地方在于进行了降维
 * 将二维降成一维
 * @author yanjie
 *
 */

public class LintCode_114 {

	public static void main(String[] args) {
		System.out.println(uniquePaths(33, 33));
	}
	
	
	
	public static int uniquePaths(int m, int n) {
        // write your code here
		int[] path = new int[n];
		for (int i = 0; i < path.length; i++) {
			path[i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				path[j] += path[j-1];
			}
		}
		return path[n-1];
    }
}
