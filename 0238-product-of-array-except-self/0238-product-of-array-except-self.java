class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        
        int[] prefix = new int[n];
        int mul = 1;
        for(int i=0;i<n;i++){
            mul*=arr[i];
            prefix[i] = mul;
        }
        
        int[] suffix = new int[n];
        mul = 1;
        for(int i=n-1; i>=0; i--){
            mul*=arr[i];
            suffix[i] = mul;
        }
        
        for(int i=0; i<n; i++){
            if(i == 0) arr[i] = suffix[i+1];
            else if(i == n-1) arr[i] = prefix[i-1];
            else {
                arr[i] = prefix[i-1]*suffix[i+1];
            }
        }
        return arr;
       
    }
}