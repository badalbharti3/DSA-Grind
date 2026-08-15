class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }
            return b - a;
        });

        StringBuilder ans = new StringBuilder();
        for (char c : keys) {
            int freq = map.get(c);
            while (freq-- > 0) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}