class Solution {
    public boolean isPalindrome(String s) {
        s= s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int n = s.length();
        int l = 0 , r = n - 1;

        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
