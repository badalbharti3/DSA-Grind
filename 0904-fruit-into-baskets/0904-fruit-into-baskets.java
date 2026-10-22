class Solution {
    public int totalFruit(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;

        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while(map.size() > 2){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }

            count = Math.max(right-left+1, count);
            right++;
        }
        return count;
    }
}