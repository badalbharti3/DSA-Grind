class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int zc = 0, max = 0, j = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 0) zc++;
            if(zc > 1){
                while(zc > 1){
                    if(nums[j] == 0) zc--;
                    j++;
                }
            }
            max = Math.max(max, i-j);
        }
        return max;



    }
}