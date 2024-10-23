class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // int l = 0;
        // int r = arr.length-1;
        // while(l<r){
        //     int mid = l+(r-l)/2;
        //     if(arr[mid+1]>arr[mid]){
        //         l=mid+1;
        //     }
        //     else{
        //         r=mid;
        //     }
        // }
        // return l;
        int low =0;
        int high =arr.length-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(arr[mid+1]>arr[mid]){
                low = mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
}