class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int count = 0;
        Collections.sort(nums); // sorted the list so that I can apply two pointers.

        // According to question, constraints were small so this brute force two pointers will work.
        for(int i=0; i<nums.size(); i++){
            int j=nums.size()-1;

            while(i<j){
                int sum = nums.get(i) + nums.get(j);
                if(sum < target){
                    count++;
                    j--;
                }
                else if(sum >= target){
                    j--;
                }
            }
        }
        return count;
    }
}