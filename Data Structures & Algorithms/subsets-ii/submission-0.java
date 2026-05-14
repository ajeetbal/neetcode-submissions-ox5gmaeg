class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        int index = 0;
        Arrays.sort(nums);

        subsetsWithDup(nums, index, result, current);
        return result;
    }

    private void subsetsWithDup(
        int[] nums, int index, List<List<Integer>> result, List<Integer> current) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            subsetsWithDup(nums, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }
}
