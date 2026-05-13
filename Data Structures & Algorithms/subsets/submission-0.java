class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        backtrack(nums, index, result, subset);
        return result;
    }

    private void backtrack(
        int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {
        // Base Condition
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // Include
        subset.add(nums[index]);
        backtrack(nums, index + 1, result, subset);

        // Exclude
        subset.remove(subset.size() - 1);
        backtrack(nums, index + 1, result, subset);
    }
}
