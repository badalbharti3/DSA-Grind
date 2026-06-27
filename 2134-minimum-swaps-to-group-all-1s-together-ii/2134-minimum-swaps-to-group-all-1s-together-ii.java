class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
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
        int num[] = new int[nums.length + ws];
        System.arraycopy(nums, 0, num, 0, nums.length);
        System.arraycopy(nums, 0, num, nums.length, ws);
        for(int i=ws; i<num.length; i++){
            if(num[i] == 0) currZero++;
            if(num[i-ws] == 0) currZero--;
            minZero = Math.min(minZero, currZero);
        }
        return minZero;
    }
}