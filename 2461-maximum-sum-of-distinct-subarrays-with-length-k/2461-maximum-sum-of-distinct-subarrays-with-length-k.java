class Solution {

    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        long sum = 0;
        long ans = 0;

        for(int i=0;i<k;i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        if(map.size()==k)
            ans = sum;

        for(int i=k;i<nums.length;i++){

            int remove = nums[i-k];
            int add = nums[i];

            sum -= remove;
            sum += add;

            map.put(remove, map.get(remove)-1);

            if(map.get(remove)==0)
                map.remove(remove);

            map.put(add,map.getOrDefault(add,0)+1);

            if(map.size()==k)
                ans=Math.max(ans,sum);
        }

        return ans;
    }
}