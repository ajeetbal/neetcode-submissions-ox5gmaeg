class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        int index = 0;
        partition(s, index, result, current);
        return result;
    }

    private void partition(String s, int index, List<List<String>> result, List<String> current) {
        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                current.add(s.substring(index, i + 1));
                partition(s, i + 1, result, current);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}
