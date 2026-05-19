class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 0;
        for(int i =2;i < n+1; i++){
            int takeOneStep = dp[i-1]+ cost[i-1];
            int takeTwoStep = dp[i-2] + cost[i-2];
            dp[i] = Math.min(takeOneStep,takeTwoStep);
        }
        return dp[n];
    }

}
