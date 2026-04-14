class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();

        return m == n ? validateFrequency(s,t) : false;
    }

    boolean validateFrequency(String s, String t){
        
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
