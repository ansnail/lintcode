package top.androidman.lintcode;

/**
 * 
 * @author yanjie
 * 需要注意要求时间复杂度是O(log n)
 */
public class LintCode_14 {
	
	public static void main(String[] args) {
		int[] nums = {2,3,4,5,6,7,8,8,8,8,10,13,14,17};
		System.out.println(binarySearch(nums, 8));
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
		if (nums[left] == target) {
			return left;
		}
		return -1;
	}

}
