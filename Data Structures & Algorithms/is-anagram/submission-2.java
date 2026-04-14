class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();

        //Approach - 1
        return m == n ? validateFrequencyUsingArray(s,t) : false; 

        //Approach - 2
      //  return m == n ? validateFrequencyUsingMap(s,t) : false;
    }


    boolean validateFrequencyUsingArray(String s, String t){
        int[] freq = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int count : freq){
            if(count != 0) {
                return false;
            }
        }
        return true;
    }    

    boolean validateFrequencyUsingMap(String s, String t){
        
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }

        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) != 0){
                return false;
            }
        }
        return true;
    }
}
