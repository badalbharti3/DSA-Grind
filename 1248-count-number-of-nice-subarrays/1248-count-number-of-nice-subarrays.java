class Solution {
    public static int atMost(int[] nums, int k){
        int ans = 0;
        int count = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] % 2 != 0) count++;
            while(count > k){
                if(nums[left] % 2 != 0) count--;
                left++;
            }
            ans += right - left + 1; 
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }
}