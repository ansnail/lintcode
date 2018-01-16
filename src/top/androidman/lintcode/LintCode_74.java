package top.androidman.lintcode;

/**
 * 
 * @author yanjie
 *
 */

public class LintCode_74 {

	public static void main(String[] args) {
		System.out.println(findFirstBadVersionII(12345678));
	}

	public static int findFirstBadVersionII(int n) {
		// write your code here
		int left = 1, right = n, mid = 0;
		while (left <= right) {
			//注意此处不建议用（right+left）/2   
			//因为在边界Integer.MAX时，相加会出现mid为负数的情况
			mid = left + (right - left) / 2;
			if (SVNRepo.isBadVersion(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

}

class SVNRepo {
	public static boolean isBadVersion(int k) {
		// 用来模拟数据
		if (k <= 89) {
			return false;
		} else {
			return true;
		}
	}
}

/**
 * 此题目可以扩充到出现不同的题目，比如一个二进制数前N为是1，后面是0，问什么时候开始出现0
 * 
 */
