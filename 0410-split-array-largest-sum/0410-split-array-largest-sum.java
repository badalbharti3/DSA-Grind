class Solution {
    private static int helper(int[] nums, int mid){
        int count = 1;
        int sum = 0;

        for(int i:nums){
            if(i+sum <= mid){
                sum+=i;
            }
            else {
                count++;
                sum = i;
            }
        }

        return count;
    }
    public int splitArray(int[] nums, int k) {
        int left = 0, sum = 0;
        for(int num:nums){
            left = Math.max(left, num);
            sum+=num;
        }

        int right = sum, ans = right;

        while(left <= right){
            int mid = left+(right-left)/2;
            int x = helper(nums, mid);

            if(x <= k){
                ans = mid; 
                right = mid-1;
            }
            else left = mid+1;
        }

        return ans;
    }
}