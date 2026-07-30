class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // finding sum for first k elements
        long r_sum = 0;
        for(int i=0; i<k; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            r_sum+=nums[i];
        }
        long best_sum = 0;
        if(map.size() == k) best_sum = r_sum;

        int i=k;
        while(i < nums.length){
            r_sum += (nums[i] - nums[i-k]);
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            map.put(nums[i-k], map.get(nums[i-k])-1);
            if(map.get(nums[i-k]) == 0) map.remove(nums[i-k]);

            if(map.size() == k) best_sum = Math.max(best_sum, r_sum);
            i++;
        }

        return best_sum;
       
    }
}