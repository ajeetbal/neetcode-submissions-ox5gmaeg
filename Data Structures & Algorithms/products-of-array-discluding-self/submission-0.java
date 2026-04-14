class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] psum = new int[nums.length];
        psum[0] = 1;
        for(int i = 1 ;i < nums.length; i++){
            psum[i] = psum[i - 1] * nums[i - 1];
        }

        int[] ssum = new int[nums.length];
        ssum[nums.length - 1] = 1;

        for(int i = nums.length - 2 ;i >= 0; i--){
            ssum[i] = ssum[i + 1] * nums[i + 1];
        }
        
        for(int i = 0 ;i < nums.length; i++){
            nums[i] = psum[i] * ssum[i];
        }
        return nums;
    }
}  


// -1  0  1  2  3

// 1  -1  0  0  0

// 0  6  6  3  1


//1246
//1128
// 48 24 6 1
      

