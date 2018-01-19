package top.androidman.lintcode;

import java.util.HashMap;

public class LintCode_111 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(climbStairsIII(18));
	}
	
	/**
	 * 递归方法  耗时较长
	 * @param n
	 * @return
	 */
	public static int climbStairsI(int n) {
        // write your code here
        if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return climbStairsI(n - 1) + climbStairsI(n-2);
    }
	
	
	/**
	 * 递归改进版   将计算过的数据进行缓存 加快计算
	 * @param n
	 * @return
	 */
	static HashMap<Integer, Integer> map = new HashMap<>();
	public static int climbStairsII(int n) {
        // write your code here
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		}else {
			int value = climbStairsII(n - 1) + climbStairsII(n-2);
			map.put(n, value);
			return value;
		}
    }
	
	
	/**
	 * 终极解法
	 * @param n
	 * @return
	 */
	public static int climbStairsIII(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int one = 1;
		int two = 2;
		int tmp = 0;
		for (int i = 3; i <= n; i++) {
			tmp = one + two;
			one = two;
			two = tmp;
		}
		return tmp;
	}
}
