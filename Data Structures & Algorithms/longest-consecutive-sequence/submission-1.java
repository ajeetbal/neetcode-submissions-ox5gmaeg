class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        int fmax = 0;

        for(int i : nums){
            if(!set.contains(i-1)){
                int max = 1;
                int n = i;
                while(set.contains(++n)){
                    max++;
                }
                if(fmax < max){
                    fmax = max;
                }
            }

        }
        return fmax;
    }
}



//[0,3,2,5,4,6,1,1]


