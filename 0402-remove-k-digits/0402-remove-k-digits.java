class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++){
            char c = num.charAt(i);

            while(!st.isEmpty() && k > 0 && st.peek() > c){
                st.pop();
                k--;
            }

            st.push(c);
        }

        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        String res = "";
        for(int i=0; i<st.size(); i++){
            res+=st.get(i);
        }

        int i=0;
        while(i < res.length() && res.charAt(i) == '0'){
            i++;
        }

        res = res.substring(i);

        return res.isEmpty() ? "0" : res;

        
    }
}