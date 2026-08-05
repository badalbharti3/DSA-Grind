class Solution {
    public int minimumLength(String s) {
        char c[] = s.toCharArray();
        int i=0, j=s.length()-1;
        while(i < j && c[i] == c[j]){
            char ch = c[i];
            while(i < j && c[i] == ch){
                i++;
            }
            while(j >= i && c[j] == ch){
                j--;
            }
        }
        return j-i+1;
    }
}