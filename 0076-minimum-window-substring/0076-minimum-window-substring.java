class Solution {
    public String minWindow(String s, String p) {
        HashMap<Character, Integer> pMap = new HashMap<>();
        for(char c: p.toCharArray()){
            pMap.put(c, pMap.getOrDefault(c,0)+1);
        }
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        int left = 0, count = p.length();
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c,0)+1);
            
            if(pMap.containsKey(c) && sMap.get(c) <= pMap.get(c)){
                count--;
            }
            
            while(count == 0){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    ans = s.substring(left, right+1);
                }
                
                char rem = s.charAt(left);
                sMap.put(rem, sMap.get(rem)-1);
                
                if(pMap.containsKey(rem) && sMap.get(rem) < pMap.get(rem)){
                    count++;
                }
                
                left++;
            }
        }
        return ans;
    }
}