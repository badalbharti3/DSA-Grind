class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        HashMap<Integer, Integer> type = new HashMap<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {

            type.put(
                fruits[right],
                type.getOrDefault(fruits[right], 0) + 1
            );

            while (type.size() > 2) {

                type.put(
                    fruits[left],
                    type.get(fruits[left]) - 1
                );

                if (type.get(fruits[left]) == 0) {
                    type.remove(fruits[left]);
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}