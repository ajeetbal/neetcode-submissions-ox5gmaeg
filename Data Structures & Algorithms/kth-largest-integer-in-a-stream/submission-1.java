class KthLargest {
    private final PriorityQueue<Integer> pq;
    private final int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;

        for(int i : nums){
            addWithoutReturn(i);
        }
    }
    
    public int add(int val) {
        addWithoutReturn(val);
        return pq.peek();
    }

    private void addWithoutReturn(int val){
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
    }
}
