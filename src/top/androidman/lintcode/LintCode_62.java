package top.androidman.lintcode;

public class LintCode_62 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1001,10001,10007,1,10,101,201};
		System.out.println(search(nums, 10001));
	}

	public static int search(int[] a, int target) {
		// write your code here
		if (a.length == 0)
			return -1;

		if (a[0] == target)
			return 0;

		if (a[a.length - 1] == target)
			return a.length - 1;
		int low = 0;
		int high = a.length - 1;
		int mid;
		int n = a.length - 1;
		while (low < high){
			mid = (low + high) / 2;
			if (a[mid] == target)
				return mid;

			if (a[mid] > target){
				if (a[mid] < a[n])
					high = mid - 1;
				if (a[mid] > a[0] && target > a[0])
					high = high - 1;
				if (a[mid] > a[0] && target < a[0])
					low = mid + 1;
			}
			if (a[mid] < target){
				if (a[mid] < a[n] && target < a[n])
					low = mid + 1;
				if (a[mid] < a[n] && target > a[n])
					high = mid - 1;
				if (a[mid] > a[0])
					low = mid + 1;
			}
			System.out.println("left=" + low + ",mid=" + mid + ",right=" + high);
		}
		return -1;
	}

}
