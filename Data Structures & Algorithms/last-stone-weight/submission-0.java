class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

       for(int stone : stones){
            maxheap.offer(stone);
       }

       if(maxheap.size() == 1){
        return maxheap.poll();
       }

       while(maxheap.size() != 1){
            int w = Math.abs(maxheap.poll() - maxheap.poll());
            maxheap.offer(w);
       }
       return maxheap.poll();
    }
}
