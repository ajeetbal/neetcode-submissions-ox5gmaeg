class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        return search(l,r,target,nums);
    }

    private int search(int l, int r, int target, int[] nums) {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				return search(l, mid - 1, target, nums);
			} else {
				return search(mid + 1, r, target, nums);
			}
		}
		return -1;
	}
}
