class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new LinkedList<>();
        int dqIndex = 0;
        int n = nums.length;

        int[] maxSlidingWindow = new int[n-k+1];

        for(int i = 0 ; i < n ; i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i] ){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k - 1){
                maxSlidingWindow[dqIndex++] = nums[dq.peekFirst()];
            }

        }

    return maxSlidingWindow;

    }
}
