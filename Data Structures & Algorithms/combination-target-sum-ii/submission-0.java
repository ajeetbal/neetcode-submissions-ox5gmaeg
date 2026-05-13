class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        int remainingTarget = target;
        // Fixes early termination bugs for unsorted inputs
        Arrays.sort(nums);
        combinationSum(nums, index, result, subset, remainingTarget);
        return result;
    }

    private void combinationSum(int[] nums, int index, List<List<Integer>> result,
        List<Integer> subset, int remainingTarget) {
        // Base Condition
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (index >= nums.length || remainingTarget < nums[index]) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if (remainingTarget < nums[i]) {
                break;
            }

            subset.add(nums[i]);
            combinationSum(nums, i + 1, result, subset, remainingTarget - nums[i]);
            subset.remove(subset.size() - 1);
        }
    }
}
