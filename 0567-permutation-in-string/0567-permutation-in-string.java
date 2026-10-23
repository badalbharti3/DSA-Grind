class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int n = s2.length(), k = s1.length();
        if(k > n) return false;
        
        for(int i=0; i<k; i++){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i),0)+1);
        }

        if(map1.equals(map2)) return true;

        for(int i=k; i<n; i++){
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i),0)+1);
            map2.put(s2.charAt(i-k), map2.get(s2.charAt(i-k))-1);
            if(map2.get(s2.charAt(i-k))==0) map2.remove(s2.charAt(i-k));

            if(map1.equals(map2)){
                return true;
            }

        }
        return false;
        

    }
}