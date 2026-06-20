class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double ans = Double.MAX_VALUE;
        
        int i=0; int j=nums.length-1;
        int idx=0;
        while(i<j){
            double avg = ((double)nums[i] + (double)nums[j])/2.0;
            ans = Math.min(avg,ans);
            i++;
            j--;
        }

        return ans;
        
    }
}