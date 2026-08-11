class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0,1);

        int preSum = 0;
        for(int i=0; i<nums.length; i++){
            preSum+=nums[i];
            int target = preSum - k;
            if(map.containsKey(target)){
                count+=map.get(target);
            }
            map.put(preSum, map.getOrDefault(preSum,0)+1);
        }
        return count;
        
    }
}