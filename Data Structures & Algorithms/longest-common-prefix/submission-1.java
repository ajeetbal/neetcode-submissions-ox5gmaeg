class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        
        if(strs.length ==1){
            return strs[0];
        }

        

        Arrays.sort(strs);
        int n = Math.min(strs[0].length(),strs[strs.length - 1].length());
        
        int p = 0;
        for(int i = 0 ; i < n ; i++){
            if(strs[0].charAt(i) != strs[strs.length - 1].charAt(i)){
                break;
            }
            p++;
        }


        return strs[0].substring(0,p);
    }
}