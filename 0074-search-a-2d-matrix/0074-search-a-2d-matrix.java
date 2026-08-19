class Solution {
    public boolean searchMatrix(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        
        int len = m*n;
        
        int left = 0, right = len-1;
        
        while(left <= right){
            int mid = left+(right-left)/2;
            
            int x = mid / m;
            int y = mid % m;
            if(mat[x][y] == k) return true;
            else if(mat[x][y] > k){
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return false;
    }
}