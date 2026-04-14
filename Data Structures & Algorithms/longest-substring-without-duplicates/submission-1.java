class Solution {
    public int lengthOfLongestSubstring(String test) {
        HashMap<Character, Integer> map = new HashMap<>();
		int result = 0;
		int l = 0, r = 0;
		while (r < test.length()) {
			if (map.containsKey(test.charAt(r))) {
				l = Math.max(map.get(test.charAt(r)), l);
			}

			map.put(test.charAt(r), r + 1 );
			result = Math.max(r - l + 1, result);
			r++;
		}
		return result;
    }
}
