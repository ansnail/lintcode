package top.androidman.lintcode;

public class LintCode_395 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] codes = {1,2,4,8,1000};
		System.out.println(firstWillWin(codes));
		
	}
	
	
	public static boolean firstWillWin(int[] values) {
        // write your code here
		int sum = 0;
		int length = values.length;
		if (length <= 2) {
			return true;
		}
		//max数组表示从i到length第一个人能取得的最大值
		int[] max = new int[length + 1];
		max[length] = 0;
		max[length - 1] = values[length - 1];
		max[length - 2] = values[length - 2] + values[length - 1];
		max[length - 3] = values[length - 3] + values[length - 2];
		
		for (int i = length - 4; i >= 0; i--) {
			max[i] = Math.max(values[i] + Math.min(max[i+2], max[i+3]), values[i] + values[i+1] + Math.min(max[i+4], max[i+3]));
		}
		PrintUitls.printS(max);
		for (int value : values) {
			sum += value;
		}
		return max[0] > sum - max[0];
    }
	
}
