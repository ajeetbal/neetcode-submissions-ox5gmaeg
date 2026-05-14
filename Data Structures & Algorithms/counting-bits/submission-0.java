class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // ans[i & (i - 1)] is the count for the number
            // with the last '1' already removed.
            ans[i] = ans[i & (i - 1)] + 1;
        }

        return ans;
    }
}
