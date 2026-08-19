class Solution {
    private static boolean possible(int[] arr, int mid, int m, int k) {
            int consecutive = 0;
            int bouquets = 0;

            for (int day : arr) {

                if (day <= mid) {
                    // Flower has bloomed
                    consecutive++;

                    // We have k consecutive flowers
                    if (consecutive == k) {
                        bouquets++;
                        consecutive = 0;

                        // Already have enough bouquets
                        if (bouquets == m) {
                            return true;
                        }
                    }

                } else {
                    // Broken sequence
                    consecutive = 0;
                }
            }

            return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m*k > bloomDay.length) return -1;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }
        
        int ans = -1;

        while(left <= right){
            int mid = left+(right-left)/2;

            if(possible(bloomDay, mid,m, k)){
                ans = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return ans;
    }
}