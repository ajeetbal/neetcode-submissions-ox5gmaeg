class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while( l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[l] <= nums[mid]){
                //left part is sorted
                if(target>= nums[l] && target < nums[mid]){
                    r = mid - 1; // Target is in the sorted left half
                }else{
                    l = mid + 1; // Target is in the right half
                }
            }else{
                //right part is sorted
                 if(target > nums[mid] && target <= nums[r]){
                    l = mid + 1; // Target is in the sorted right half
                }else{
                    r = mid - 1; // Target is in the left half
                }
            }

        }
        return -1;
    }
}
