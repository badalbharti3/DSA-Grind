class Solution {
    public void reverseString(char[] c) {
       int s = 0, e = c.length-1;
       while(s<e){
        char temp = c[s];
        c[s] = c[e];
        c[e] = temp;
        s++;e--;
       }
    }
}