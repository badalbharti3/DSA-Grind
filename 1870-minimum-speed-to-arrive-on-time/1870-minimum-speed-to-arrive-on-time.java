class Solution {
    public static double helper(int[] dist, double mid) {
        double res = 0;

        for (int i = 0; i < dist.length - 1; i++) {
            res = res + Math.ceil((double) dist[i] / mid);
        }
        res = res + (double) dist[dist.length - 1] / mid;

        return res;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = 10000000;
        int ans = -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            double x = helper(dist, mid);
            if(x <= hour){
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }
}