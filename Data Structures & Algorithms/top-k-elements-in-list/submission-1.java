class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		List<Integer>[] buckets = new List[nums.length + 1];

		for (int key : map.keySet()) {
			int freq = map.get(key);

			if (buckets[freq] == null) {
				buckets[freq] = new ArrayList<>();
			}
			buckets[freq].add(key);
		}

		List<Integer> out = new ArrayList<>();

		for (int i = buckets.length - 1; i >= 0 ; i--) {
			if (buckets[i] != null) {
				if (k <= 0) {
					break;
				}
				out.addAll(buckets[i]);
				k -= buckets[i].size();
			}
		}

		return out.stream().mapToInt(i -> i).toArray();
	
    }
}
