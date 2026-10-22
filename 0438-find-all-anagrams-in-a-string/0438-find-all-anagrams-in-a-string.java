
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int k = p.length();

        if (k > s.length()) return res;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : p.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < k; i++) {
            map2.put(s.charAt(i),
                map2.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (map1.equals(map2)) res.add(0);

        for (int i = k; i < s.length(); i++) {
            map2.put(s.charAt(i),
                map2.getOrDefault(s.charAt(i), 0) + 1);

            map2.put(s.charAt(i - k),
                map2.get(s.charAt(i - k)) - 1);

            if (map2.get(s.charAt(i - k)) == 0) {
                map2.remove(s.charAt(i - k));
            }

            if (map1.equals(map2)) {
                res.add(i - k + 1);
            }
        }

        return res;
    }
}
