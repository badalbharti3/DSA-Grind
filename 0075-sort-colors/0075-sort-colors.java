class Solution {
    public void sortColors(int[] arr) {
       // dutch national algo one pass
       int left = 0, mid = 0, right = arr.length - 1;
       while(mid <= right) {
        if(arr[mid] == 0){
            int t = arr[mid];
            arr[mid] = arr[left];
            arr[left] = t;
            left++;
            mid++;
        }
        else if(arr[mid] == 1){
            mid++;
        }
        else{
            int t = arr[mid];
            arr[mid] = arr[right];
            arr[right] = t;
            right--;
        }

       }
    }
}