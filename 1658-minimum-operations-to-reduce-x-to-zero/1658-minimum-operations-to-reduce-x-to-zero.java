class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int i:nums){
            total += i;
        }

        int k = total - x;
        if(k == 0) return nums.length;
        if(k < 0) return -1;
        int ans = -1;
        int left = 0, sum = 0;
        for(int right = 0; right < nums.length; right++){
            sum+=nums[right];
            if(sum == k) ans = Math.max(ans, right-left+1);
            while(sum > k && left < nums.length){
                sum-=nums[left++];
                if(sum == k) ans = Math.max(ans,right - left+1);
            }
        }
        return ans == -1 ? ans: nums.length-ans;
    }
}