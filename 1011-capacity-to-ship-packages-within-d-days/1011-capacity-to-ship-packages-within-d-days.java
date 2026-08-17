class Solution {
    private static int helper(int[] weights, int spd) {
        int days = 1;
        int sum = 0;
        int i = 0;

        while (i < weights.length) {

            if (sum + weights[i] <= spd) {
                sum += weights[i];
                i++;
            } else {
                days++;
                sum = 0;
            }
        }

    return days;
}
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int total = 0;
        for(int i:weights){
            max = Math.max(i, max);
            total+=i;
        }

        int left = max, right = total;
        int ans = 0;
        while(left <= right){
            int mid = left+(right-left)/2;
            int x = helper(weights, mid);

            if(x <= days){
                ans = mid;
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return ans;
    }
}