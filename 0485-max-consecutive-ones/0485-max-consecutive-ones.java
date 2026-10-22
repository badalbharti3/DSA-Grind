class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0;
        int max_ones = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                ones++;
                max_ones = Math.max(ones, max_ones);
            }
            else ones = 0;
        }

        return max_ones;
    }
}