class Solution {
    private boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    public String reverseVowels(String st) {
        char[] s = st.toCharArray();
        int i = 0, j = st.length()-1;
        while(i < j){
            if(isVowel(s[i]) && isVowel(s[j])){
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
            else if(!isVowel(s[i])) {
                i++;
            }
            else j--;
        }
        return String.valueOf(s);
    }
}