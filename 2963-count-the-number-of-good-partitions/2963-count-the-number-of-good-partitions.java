class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            last.put(nums[i], i);
        }

        long res = 1;
        int i = 0, j = last.get(nums[0]);

        while (i < n) {
            j = Math.max(j, last.get(nums[i]));
            if (i == j && i != n - 1) {
                res = (res * 2) % 1000000007;
            }
            i++;
        }

        return (int) res;
    }
}