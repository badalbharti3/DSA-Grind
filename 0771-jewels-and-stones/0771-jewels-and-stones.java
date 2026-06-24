class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(char c:jewels.toCharArray()){
            map1.put(c, map1.getOrDefault(c,0)+1);
        }

        for(char c:stones.toCharArray()){
            if(map1.containsKey(c)){
                count++;
            }
        }
        return count;
    }
}