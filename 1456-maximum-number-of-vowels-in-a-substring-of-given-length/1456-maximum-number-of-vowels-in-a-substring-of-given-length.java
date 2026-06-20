class Solution {
    public int maxVowels(String s, int k) {
        

        int vowCount = 0; 
        for(int i=0; i<k; i++){
            char ch = s.charAt(i);
            if("AEIOUaeiou".indexOf(ch) != -1){
                vowCount++;
            }
        }
        int max = vowCount;
        

        for(int i=k; i<s.length(); i++){

            if("AEIOUaeiou".indexOf(s.charAt(i)) != -1){
                    vowCount++;
            }
            if("AEIOUaeiou".indexOf(s.charAt(i-k)) != -1){
                vowCount--;
            }

        
            max = Math.max(max,vowCount);
        }
        return max;
    }
}