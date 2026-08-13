class Solution {
    public int maxAbsoluteSum(int[] nums) {
      int sum = 0;
      int max = nums[0];
      for(int i:nums){
        sum+=i;
        max = Math.max(max, sum);

        if(sum < 0) sum = 0;
      }  

      sum = 0;
      int min = nums[0];
      for(int i:nums){
        sum+=i;
        min = Math.min(sum, min);

        if(sum > 0) sum = 0;
      }

      return Math.max(Math.abs(min), max);
    }
}