package top.androidman.lintcode;

/**
 * 
 * @author yanjie
 * 
 *         理解旋转后的数组其实就是两个有序数组，这是能用二分查找的理论基础
 * 
 */

public class LintCode_62 {

	public static void main(String[] args) {
		int[] nums = { 438, 443, 446, 449, 454, 457, 462, 488, 377, 382, 386, 391, 394, 399, 402, 405, 407, 411, 413, 417, 419, 422, 427, 431, 434, 437 };
		System.out.println(search(nums, 488));
	}

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (target < nums[mid]) {
				if (nums[mid] < nums[right]) {
					right = mid - 1;
				} else {
					if (target < nums[left]) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
			} else if (target > nums[mid]) {
				if (nums[mid] > nums[left]) {
					left = mid + 1;
				} else {
					if (target == nums[right]) {
						return right;
					}else if (target < nums[right]) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
			} else {
				return mid;
			}
		}
		return -1;
	}

}
