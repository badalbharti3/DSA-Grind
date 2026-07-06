class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";

        Map<Character,Integer> tar = new HashMap<>();

        for(char c : t.toCharArray())
            tar.put(c, tar.getOrDefault(c,0)+1);

        int count = t.length();

        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        char[] ch = s.toCharArray();

        for(int right = 0; right < ch.length; right++) {

            if(tar.containsKey(ch[right])) {

                if(tar.get(ch[right]) > 0)
                    count--;

                tar.put(ch[right], tar.get(ch[right]) - 1);
            }

            while(count == 0) {

                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                if(tar.containsKey(ch[left])) {

                    tar.put(ch[left], tar.get(ch[left]) + 1);

                    if(tar.get(ch[left]) > 0)
                        count++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}