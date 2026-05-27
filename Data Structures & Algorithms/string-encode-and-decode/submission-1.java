class Solution {
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length())
                    .append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        int len = str.length();
        int currentIndex = 0;
        List<String> res = new ArrayList<>();
        while(currentIndex < len){
            int startIndex = str.indexOf("#",currentIndex);
            int strLen = Integer.parseInt(str.substring(currentIndex,startIndex));
            currentIndex = startIndex + strLen + 1;
            res.add(str.substring(startIndex+1,currentIndex));
        }
        return res;
    }
}
