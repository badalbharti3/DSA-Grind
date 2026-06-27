class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i=0, j=0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(i<n){
            sum += nums[i];
            while(sum >= target){
                min = Math.min(min, i-j+1);
                sum-=nums[j++];
            }
            i++;
           
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
}