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
        // Base Condition
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        //Choice 1: Include current element in subset
        subset.add(nums[index]);
        subsets(nums, index + 1, result, subset);

        //Backtrack: remove the element we just added
        subset.remove(subset.size() - 1);

        //Choice 2: Exclude current element from subset
        subsets(nums, index + 1, result, subset);
    }
}
