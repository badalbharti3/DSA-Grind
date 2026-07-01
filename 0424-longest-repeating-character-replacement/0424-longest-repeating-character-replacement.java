class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0, mxF = 0;
        int n = s.length();
        int j = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            mxF = Math.max(mxF, map.get(c));
            int changes = (i - j+1) - mxF;
            if(changes <= k){
                max = Math.max(max, i-j+1);
            }
            while((i - j + 1) - mxF  > k){
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
                j++;
            }
        }
        return max;

    }
}