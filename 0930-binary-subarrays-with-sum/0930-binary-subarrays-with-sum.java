class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int i=0, j=0;
        int currSum = 0;
        int countZ=0;
        while(i<nums.length){
            currSum+=nums[i];
            while(j<i && (nums[j]==0 || currSum > goal)){
                if(nums[j] == 0) countZ++;
                else countZ=0;
                currSum-=nums[j];
                j++;
            }

            if(currSum == goal) count+= 1+countZ;
            i++;

        }
        return count;
    }
}