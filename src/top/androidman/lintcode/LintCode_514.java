package top.androidman.lintcode;

public class LintCode_514 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		int k = 8;
		System.out.println(numWays(n, k));

	}
	
	
	public static int numWays(int n, int k) {
        // write your code here
		int[] nums = new int[n];
		if (n == 1) {
			return k;
		}
		if (n == 2) {
			return k*k;
		}
		nums[0] = k;
		nums[1] = k*k;
		for (int i = 2; i < nums.length; i++) {
			nums[i] = (nums[i-2]+ nums[i-1])*(k-1);
		}
		return nums[n-1];
    }

}
