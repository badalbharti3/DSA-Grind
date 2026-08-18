class Solution {
    private static int helper(int[] nums, int minDistance) {
        int count = 1;
        int last = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= minDistance) {
                count++;
                last = nums[i];
            }
        }

        return count;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = 1_000_000_000;
        int ans = -1;
        while(left <= right){
            int mid = left+(right-left)/2;

            int x = helper(position, mid);
            if(x >= m){
                ans = mid;
                left = mid+1;
            }
            else right = mid-1;
        }
        return ans;
    }
}