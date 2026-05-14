class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if(digits == null || digits.length() == 0){
            return result;
        }
        //Pre-map digits to letters
        Map<Character, String> data = new HashMap<>();
        data.put('2', "abc");
        data.put('3', "def");
        data.put('4', "ghi");
        data.put('5', "jkl");
        data.put('6', "mno");
        data.put('7', "pqrs");
        data.put('8', "tuv");
        data.put('9', "wxyz");
        StringBuilder current = new StringBuilder();
        int index = 0;

        letterCombinations(digits, index, result, current, data);
        return result;
    }

    private void letterCombinations(String digits, int index, List<String> result,
        StringBuilder current, Map<Character, String> data) {
        // 2. Base Case: If the string length matches digits length
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // 3. Get the letters for the current digit (e.g., '2' -> "abc")
        String letters = data.get(digits.charAt(index));

        // 4. The Loop: Try every letter for this specific digit
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i)); //Choose
            letterCombinations(digits, index + 1, result, current, data); //Explore
            current.deleteCharAt(current.length() - 1); //backtrack
        }
    }
}
