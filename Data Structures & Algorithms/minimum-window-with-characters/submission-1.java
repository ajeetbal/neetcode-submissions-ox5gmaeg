class Solution {
    public String minWindow(String s1, String s2) {
        if (s1.length() < s2.length()) return "";

        // Use a single frequency array for the target characters
        int[] targetCounts = new int[128];
        for (char c : s2.toCharArray()) {
            targetCounts[c]++;
        }

        // Track how many unique characters from s2 still need to be satisfied
        int requiredChars = s2.length();
        int l = 0, minLen = Integer.MAX_VALUE, startIdx = -1;

        for (int r = 0; r < s1.length(); r++) {
            char rightChar = s1.charAt(r);
            
            // If rightChar is needed by s2, decrement our remaining required count
            if (targetCounts[rightChar] > 0) {
                requiredChars--;
            }
            // Reduce target count (negative values mean we have extra copies of this char)
            targetCounts[rightChar]--;

            // When the window contains all characters from s2
            while (requiredChars == 0) {
                // Update the minimum window metrics
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }

                char leftChar = s1.charAt(l);
                // Put leftChar back into the required pool
                targetCounts[leftChar]++;
                
                // If it becomes positive, it means we actually need it to satisfy s2
                if (targetCounts[leftChar] > 0) {
                    requiredChars++;
                }
                l++; // Shrink window
            }
        }

        // Return substring only if a valid window was found
        return startIdx == -1 ? "" : s1.substring(startIdx, startIdx + minLen);
    }
}