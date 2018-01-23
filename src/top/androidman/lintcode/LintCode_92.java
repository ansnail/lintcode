package top.androidman.lintcode;

public class LintCode_92 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	
	public static int backPack(int m, int[] packs) {
        // write your code here
		int[] weights = new int[m];
		for (int i = 0; i < weights.length; i++) {
			if (i < packs[0]) {
				weights[i] = 0;
			}else {
				weights[i] = packs[0];
			}
		}
		for (int i = 0; i < packs.length; i++) {
			for (int j = 0; j < m; j++) {
				
			}
		}
		
		
		return 0;
    }

}
