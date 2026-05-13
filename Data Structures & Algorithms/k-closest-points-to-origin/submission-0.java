class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i<points.length;i++) {
            maxHeap.offer(new int[] {calculateDistance(points[i]), i});
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        ArrayList<int[]> result = new ArrayList<>();

        while(!maxHeap.isEmpty()){
            result.add(points[maxHeap.poll()[1]]);
        }
        return result.toArray(new int[k][]);
    }

    private int calculateDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
