class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        int max = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
        }

        int[] hash = new int[max + 1];

        for (int i : nums) {
            hash[i]++;
        }

        // k = 1: every element forms its own subarray
        if (k == 1) {
            int ans = -1;

            for (int i = 0; i < hash.length; i++) {
                if (hash[i] == 1) {
                    ans = Math.max(ans, i);
                }
            }

            return ans;
        }

        // k = n: only the whole array is considered
        if (k == n) {
            return max;
        }

        // 1 < k < n
        if (hash[nums[0]] == 1 && hash[nums[n - 1]] == 1) {
            return Math.max(nums[0], nums[n - 1]);
        }

        if (hash[nums[0]] == 1) {
            return nums[0];
        }

        if (hash[nums[n - 1]] == 1) {
            return nums[n - 1];
        }

        return -1;
    }
}