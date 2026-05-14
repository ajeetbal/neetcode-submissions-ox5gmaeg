class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        subsets(nums, index, result, subset);
        return result;
    }

    private void subsets(
        int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {
        
        // Add every state we reach to the result
        result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            subsets(nums, i + 1, result, subset); // Move forward
            subset.remove(subset.size() - 1);     // Backtrack
        }
    }
}
