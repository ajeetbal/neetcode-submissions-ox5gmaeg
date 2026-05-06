class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
		int n = position.length;

		Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			map.put(position[i], speed[i]);
		}

		int fleetCount = 0;
		double previousArrivalTime = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			double currentArrivalTime = (double) (target - entry.getKey()) / entry.getValue();

			if (currentArrivalTime > previousArrivalTime) {
				fleetCount++;
				previousArrivalTime = currentArrivalTime;
			}
		}
		return fleetCount;
	
    }
}
