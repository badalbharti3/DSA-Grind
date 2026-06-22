class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int n = s2.length();

        if(k>n) return false;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        for(int i=0; i<k; i++){
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i),0)+1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i),0)+1);
        }
        if(s1Map.equals(s2Map)) return true;

        for(int i=k; i<n; i++){
            char right = s2.charAt(i);
            s2Map.put(right, s2Map.getOrDefault(right, 0)+1);

            char left = s2.charAt(i-k);
            s2Map.put(left, s2Map.get(left) - 1);
            if(s2Map.get(left) == 0){
                s2Map.remove(left);
            }

            if(s1Map.equals(s2Map)){
                return true;
            }

        }
        return false;
    }
}