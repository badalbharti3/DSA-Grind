class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Create a hashmap and put count frequencies of each element.
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        // 2. Sort keys based on the given condition.
        List<Integer> keys = new ArrayList<>(map.keySet());

        keys.sort((a,b) -> {
            if(!map.get(a).equals(map.get(b))) return map.get(b) - map.get(a);
            return b - a;
        }
        );

        //3. Take k elements from keys.
        int[] res = new int[k];

        for(int i=0; i<k; i++){
            res[i] = keys.get(i);
        }

        return res;
    }
}