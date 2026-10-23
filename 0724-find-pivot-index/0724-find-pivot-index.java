class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int i:nums) total += i;

        int l_sum = 0;
        for(int i=0;i<nums.length;i++){
            int r_sum = total - l_sum - nums[i];
            if(r_sum == l_sum) return i;
            l_sum+=nums[i];
        }

        return -1;
    }
}