class Solution {
     private static int findFirstIdx(int arr[], int left, int right, int x){
        int idx = -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            
            if(arr[mid] == x){
                idx = mid;
                right = mid - 1;
            }
            else if(arr[mid] > x){
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return idx;
    }
    private static int findLastIdx(int arr[], int left, int right, int x){
        int idx = -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            
            if(arr[mid] == x){
                idx = mid;
                left = mid+1;
            }
            else if(arr[mid] > x){
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return idx;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int a = findFirstIdx(nums, 0, n-1, target);
        int b = findLastIdx(nums, 0, n-1, target);
        return new int[]{a,b};
    }
}