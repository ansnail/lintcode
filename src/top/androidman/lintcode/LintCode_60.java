package top.androidman.lintcode;

/**
 * 题目：搜索插入位置
 * @author yanjie
 * 需要注意要求时间复杂度是O(log n)
 */
public class LintCode_60 {
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 4, 5, 5};
		System.out.println(binarySearch(nums, 0));
	}
	
	public static int binarySearch(int[] nums, int target) {
        //write your code here
		int left = 0;
		int right = nums.length - 1;
		
		while (left <= right) {
			int mid = left + (right - left)/2;
			if (target <= nums[mid]) {
				right = mid -1;
			}else{
				left = mid + 1;
			}
		}
		return left;
	}

}
