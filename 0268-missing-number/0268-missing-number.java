class Solution {
    public int missingNumber(int[] nums) {
        int totalXor = 0;
        int n = nums.length;
        for(int i=1; i<=n; i++){
            totalXor = totalXor ^ i;
        }

        int realXor = 0;
        for(int i:nums){
            realXor ^= i;
        }

        return totalXor ^ realXor;

    }
}