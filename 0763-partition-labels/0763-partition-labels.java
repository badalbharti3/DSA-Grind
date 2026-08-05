class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        char c[] = s.toCharArray();
        int[] map = new int[26];
        for(int i=0; i<n; i++){
            map[c[i] - 'a'] = i;
        }
        
        List<Integer> ans = new ArrayList<>();
        int i=0;
        // Main Logic

        while(i < n){
            int end = map[c[i]-'a'];
            int j = i;
            while(j<end){
                end = Math.max(end, map[c[j]-'a']);
                j++;
            }
            ans.add(j-i+1);
            i = j+1;
        }
        return ans;
    }
}