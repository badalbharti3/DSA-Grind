class Solution {
    public int minRotations(String s) {
        int total = 0;
        char last = '0';

        for(char c: s.toCharArray()){
            int x = Math.abs((last - '0') - (c - '0'));
            total += Math.min(x, 10-x);

            last = c;
        }
        return total;
    }
}