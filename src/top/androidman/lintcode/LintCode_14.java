package top.androidman.lintcode;

/**
 * 
 * @author yanjie
 * 需要注意要求时间复杂度是O(log n)
 */
public class LintCode_14 {
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 4, 5, 5};
		System.out.println(binarySearch(nums, 5));
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
		//需要注意  left < nums.length  这个条件
		//当target大于所有值并且不存在时，left的最终值是越界的
		if (left < nums.length && nums[left] == target) {
			return left;
		}
		return -1;
	}

}
