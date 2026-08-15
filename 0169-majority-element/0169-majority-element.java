class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int i:nums) {
            if(count == 0){
                candidate = i;
            }

            if(i == candidate) count++;

            if(i != candidate) count--;
        }
        return candidate;
    }
}