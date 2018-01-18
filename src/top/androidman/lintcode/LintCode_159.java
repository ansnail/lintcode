package top.androidman.lintcode;

/**
 * 
 * @author yanjie
 * 需要注意要求时间复杂度是O(log n)
 */
public class LintCode_159 {
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 4, 5, 5};
		System.out.println(findMin(nums));
	}
	
	public static int findMin(int[] nums) {
        //write your code here
		int left = 0;
		int right = nums.length - 1;
		
		while (left < right && nums[left] > nums[right]) {
			int mid = left + (right - left)/2;
			if (nums[left] <= nums[mid]) {
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		return nums[left];
	}

}
