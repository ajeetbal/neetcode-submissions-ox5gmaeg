class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int l = 0;
		int maxWindow = 0;
        for(int r = 0; r < s.length() ; r ++){
			// Increment frequency of the incoming character
            freq[s.charAt(r) - 'A']++;

            // Track the highest frequency of any single character inside the current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);
           
			int windowLength = r - l + 1;
		    // If the remaining characters to replace exceed k, shift the left boundary
            if(windowLength - maxFreq  > k){
                freq[s.charAt(l) - 'A'] --;
                l++;
            }

			windowLength = r - l + 1;
			// Capture the maximum valid window size seen
            maxWindow = Math.max(maxWindow,windowLength);

        }
        return maxWindow;
    }
}
