class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return minCostClimbingStairs(cost,n);
    }

    private int minCostClimbingStairs(int[] cost,int i) {
        if(i==0|| i==1){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int takeOneStep = minCostClimbingStairs(cost,i-1) + cost[i-1];
        int takeTwoStep = minCostClimbingStairs(cost,i-2) + cost[i-2];

        return dp[i] = Math.min(takeOneStep,takeTwoStep);
    }

}
