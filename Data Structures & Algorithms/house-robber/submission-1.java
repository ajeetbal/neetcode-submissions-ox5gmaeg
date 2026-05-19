class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp= new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;

        for(int i = 1; i < n+1 ; i++){
           int pick=nums[i-1];
            if(i > 1){
                pick += dp[i-2];
            }
           
            int notPick = dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[n];
        
    }

  
}
