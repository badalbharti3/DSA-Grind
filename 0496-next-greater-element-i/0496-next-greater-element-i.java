class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length; 

        int max = -1;
        for(int i:nums2){
            max = Math.max(i,max);
        }
        int[] nextGreater = new int[max+1];
        Stack<Integer> st = new Stack<>();

        for(int i=m-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() < nums2[i]){
                st.pop();
            }
            nextGreater[nums2[i]] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = nextGreater[nums1[i]];
        }
        return res;
    }
}