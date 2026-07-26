class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        int res = Integer.MAX_VALUE;
        int j = 0;
        while(j<n){
            if(j == 0){
                prefix[j] = nums[j];
            }
            else {
                prefix[j] = prefix[j-1]+nums[j];
            }
            if(prefix[j] >= k){
                res = Math.min(res, j+1);
            }

            while(!dq.isEmpty() && prefix[j] <= prefix[dq.peekLast()]){
                dq.pollLast();
            }

            while(!dq.isEmpty() && (prefix[j] - prefix[dq.peek()]) >= k){
                res = Math.min(res, j-dq.peek());
                dq.pollFirst();
            }

            dq.offer(j);
            j++;
        }
        return res == Integer.MAX_VALUE ? -1:res;
    }
}