class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];

        for (char c : s1.toCharArray()) {
              freqS1[c- 'a']++;
        }
        
        int windowSize = s1.length();
        int l = 0;
        for( int r = 0 ; r < s2.length() ; r++){
            freqS2[s2.charAt(r) - 'a']++;
            if((r - l + 1) > windowSize){
                freqS2[s2.charAt(l) - 'a']--;
                l++;
            }
            
            if(matches(freqS1,freqS2)){
                return true;
            }
            
        }
        return false;
    }
private boolean matches(int[] arr1, int[] arr2) {
    for (int i = 0; i < 26; i++) {
        if (arr1[i] != arr2[i]) return false;
    }
    return true;
}

}
