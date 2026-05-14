class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permute(nums, result, list);
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }

            list.add(nums[i]);
            permute(nums, result, list);

            list.remove(list.size() - 1);
        }
    }
}
