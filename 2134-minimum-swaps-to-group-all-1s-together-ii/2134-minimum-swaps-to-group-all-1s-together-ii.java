class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        int n = nums.length;
        for(int i:nums){
            if(i == 1){
                ones++;
            }
        }
        int ws = ones, currZero = 0;
        for(int i=0; i<ws; i++){
            if(nums[i] == 0){
                currZero++;
            }
        }
        int minZero = currZero;
        int s = 0;
        int e = ws-1;

        while(s<n){
            if(nums[s] == 0) currZero--;
            s++;
            e++;
            if(nums[e%n] == 0) currZero++;
            minZero = Math.min(minZero,currZero);
        }

        return minZero;
    }
}