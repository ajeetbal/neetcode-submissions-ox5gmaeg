class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int l = 0 , r = n - 1;
        int maxArea = -1;
        while( l < r){
            int h = Math.min(heights[l],heights[r]);
            int w = r - l;
            maxArea = Math.max(maxArea,h*w);

            if(heights[l] > heights[r]){
                r--;
            }
            else{
                l++;
        }
        }
        return maxArea;

    }
}
