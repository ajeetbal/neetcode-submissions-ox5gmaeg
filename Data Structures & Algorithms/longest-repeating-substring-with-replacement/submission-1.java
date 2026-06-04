class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int l = 0;
		int maxWindow = 0;
        for(int r = 0; r < s.length() ; r ++){
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);

			int windowLength = r - l + 1;

            if(windowLength - maxFreq  > k){
                freq[s.charAt(l) - 'A'] --;
                l++;
            }

			windowLength = r - l + 1;
            maxWindow = Math.max(maxWindow,windowLength);

        }
        return maxWindow;
    }
}
