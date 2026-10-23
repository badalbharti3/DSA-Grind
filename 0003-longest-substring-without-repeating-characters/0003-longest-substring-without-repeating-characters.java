class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, left = 0;

        for(int i=0; i<s.length(); i++){
            while(!set.isEmpty() && set.contains(s.charAt(i))){
                set.remove(s.charAt(left++));
            }

            set.add(s.charAt(i));
            ans = Math.max(ans, i-left+1);
        }
        return ans;
    }
}