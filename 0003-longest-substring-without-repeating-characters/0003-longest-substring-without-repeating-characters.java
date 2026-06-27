class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> set = new ArrayList<>();
int left = 0, max = 0;

for(int right = 0; right < s.length(); right++) {

    while(set.contains(s.charAt(right))) {
        set.remove(Character.valueOf(s.charAt(left)));
        left++;
    }

    set.add(s.charAt(right));

    max = Math.max(max, right - left + 1);
}
return max;
    }
}