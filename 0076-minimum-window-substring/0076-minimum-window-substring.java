class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] tar = new int[128];

        for (char c : t.toCharArray())
            tar[c]++;

        int count = t.length();
        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        char[] ch = s.toCharArray();

        for (int right = 0; right < ch.length; right++) {

            if (tar[ch[right]] > 0)
                count--;

            tar[ch[right]]--;

            while (count == 0) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                tar[ch[left]]++;

                if (tar[ch[left]] > 0)
                    count++;

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}