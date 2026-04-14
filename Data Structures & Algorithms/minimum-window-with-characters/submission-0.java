class Solution {
    public String minWindow(String s1, String s2) {
        

		int l = 0, r = 0;
		String result = "";
		int minLen = Integer.MAX_VALUE;

		Map<Character, Integer> target = new HashMap<>();
		for (Character c : s2.toCharArray()) {
			target.put(c, target.getOrDefault(c,  0) + 1);
		}

		Map<Character, Integer> windows = new HashMap<>();

		int requiredLen = target.size();
		int formed = 0;

		while (r < s1.length()) {
			char c = s1.charAt(r);
			windows.put(c, windows.getOrDefault(c,  0) + 1);
			if (target.containsKey(c) && windows.get(c).equals(target.get(c))) {
				formed++;
			}

			while (l <= r && formed == requiredLen) {
				if (r - l + 1 < minLen) {
					minLen = r - l + 1;
					result = s1.substring(l, r + 1);
				}

				Character toBeRemoved = s1.charAt(l);

				if (target.containsKey(toBeRemoved) && windows.get(toBeRemoved).equals(target.get(toBeRemoved))) {
					formed--;
				}

				windows.put(toBeRemoved, windows.get(toBeRemoved) - 1);

				l++;
			}

			r++;
		}

		return result;

	
    }
}
