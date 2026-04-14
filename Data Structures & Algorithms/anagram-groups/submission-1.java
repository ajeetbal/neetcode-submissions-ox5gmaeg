class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
      //  return approach1(strs);
          return approach2(strs);
    }

    List<List<String>> approach2(String[] strs){
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.computeIfAbsent(key,str -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }    

    List<List<String>> approach1(String[] strs){
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
            for(int i = 0 ; i < s.length() ; i++){
                freq[s.charAt(i) - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for(int i : freq){
                builder.append(i).append("#");
            }
            String key = builder.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
