class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vow = new HashMap<>();
        HashMap<Character, Integer> con = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if("aeiou".indexOf(s.charAt(i)) != -1){
                vow.put(s.charAt(i),vow.getOrDefault(s.charAt(i),0)+1);
            }
            else {
                con.put(s.charAt(i),con.getOrDefault(s.charAt(i),0)+1);
            }
        }
        int max_1 = 0; 
        int max_2 = 0;
        for(int value : vow.values()) {
            max_1 = Math.max(max_1, value);
        }

        for(int value: con.values()){
            max_2 = Math.max(max_2, value);
        }

        return max_1+max_2;

    }
}