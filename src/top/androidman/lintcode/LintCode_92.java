package top.androidman.lintcode;

import java.util.Arrays;

public class LintCode_92 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] packs = { 3, 4, 8, 5 };
		System.out.println(backPack(10, packs));
	}
	
	
	public static int backPack(int m, int[] packs) {
		int[][] results = new int[packs.length][m+1];
		for (int i = 1; i <= m; i++) {
			if (packs[0] <= i) {
				results[0][i] = packs[0];
			} else {
				results[0][i] = 0;
			}
			for (int j = 1; j < packs.length; j++) {
				if (i < packs[j]) {
					results[j][i] = results[j-1][i];
				} else {
					results[j][i] = Math.max(results[j-1][i - packs[j]] + packs[j], results[j-1][i]);
				}
			}
		}
		return results[packs.length-1][m];
	}
	
	
	
	/**
	 * 本来想尝试O(m)的空间复杂度   貌似有点问题
	 * @param m
	 * @param packs
	 * @return
	 */
	public static int backPackI(int m, int[] packs) {
		int[] first = new int[m+1];
		int[] second = new int[m+1];
		int[] tmp = new int[m+1];
		for (int i = 0; i < first.length; i++) {
			if (i >= packs[0]) {
				first[i] = packs[0];
			}
		}
		for (int i = 1; i < packs.length; i++) {
			tmp = first;
			System.out.println("+++++++++++++++之前++++++++++++++++");
			System.out.println("111==="+Arrays.toString(first));
			System.out.println("222==="+Arrays.toString(second));
			System.out.println("+++++++++++++++之前++++++++++++++++");
			for (int j = 0; j <= m; j++) {
				if (packs[i] > j) {
					second[j] = first[j];
				}else {
					second[j] = Math.max(first[j - packs[i]] + packs[i], first[j]);
				}
			}
			System.out.println("++++++++++++++++之后+++++++++++++++");
			System.out.println("111==="+Arrays.toString(first));
			System.out.println("222==="+Arrays.toString(second));
			System.out.println("++++++++++++++++之后+++++++++++++++");
			first = tmp;
			first = second;
		}
		
		return 0;
	}
	
}
