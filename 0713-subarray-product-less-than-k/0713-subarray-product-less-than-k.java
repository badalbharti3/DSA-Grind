class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int mul = 1;
        int left = 0;
        int count = 0;
        for(int right = 0; right < nums.length; right++){
            mul*=nums[right];
            while(mul >= k){
                mul/=nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}