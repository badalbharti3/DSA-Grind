class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int i=0, j=1;
        int count = 0;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                nums[j] = 101;
                j++;
                count++;
            }
            else {
                i = j;
                j++;
            }
        }

        // now move 101 to end 
        int idx = 0;
        for(int t=0; t<nums.length; t++){
            if(nums[t] != 101){
                nums[idx++] = nums[t];
            }
        }
        return nums.length - count;

    }
}