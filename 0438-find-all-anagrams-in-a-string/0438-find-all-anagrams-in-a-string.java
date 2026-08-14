class Solution {
    private static boolean areEqual(int[] a1, int[] a2){
        for(int i=0; i<26; i++){
            if(a1[i] != a2[i]) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int k = p.length();
        int n = s.length();

        if(k > n) return res;

       
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(char c:p.toCharArray()){
            arr1[c-'a']++;
        }

        for(int i=0; i<k; i++){
            arr2[s.charAt(i) - 'a']++;
        }

        if(areEqual(arr1, arr2)) res.add(0);

        for(int i=k; i<n; i++){
            char c = s.charAt(i);
            arr2[c-'a']++;
            arr2[s.charAt(i-k)-'a']--;

            if(areEqual(arr1, arr2)){
                res.add(i-k+1);
            }
        }
        return res;
    }
}