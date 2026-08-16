class Solution {
    public int search(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        
        while(left <= right){
            int mid = left+(right-left)/2;
            if(arr[mid] == key) return mid;
            // check which part is sorted and does key belongs to that part
            if(arr[mid] >= arr[left]){
                //left part sorted
                
                if(key < arr[mid] && key >= arr[left]){
                    //now search key in left part
                    right = mid - 1;
                }
                else {
                    left = mid+1;
                }
            }
            else {
                if(key > arr[mid] && key <= arr[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}