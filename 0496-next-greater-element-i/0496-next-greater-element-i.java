class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length; 
        int m = nums2.length; 

        int max = -1;
        for(int i:nums2){
            max = Math.max(max, i);
        }
        int[] nextGreater = new int[max+1];
       
        Stack<Integer> st = new Stack<>();
        for(int i=m-1; i>=0; i--){
            
            while(!st.isEmpty() && st.peek() < nums2[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nextGreater[nums2[i]] = st.peek();
            }
            else nextGreater[nums2[i]] = -1;
            st.push(nums2[i]);
        }
        int[] res = new int[n];
        int idx = 0;
        
        for(int i:nums1){
            res[idx++] = nextGreater[i];
        }
        return res;
    }
}