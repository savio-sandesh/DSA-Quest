class Solution {
    public int findPeakElement(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while(s<e){
            int m=s+(e-s)/2;
            if(nums[m]>nums[m+1]){
                e=m;
            }
            else{
                s=m+1;
            }
        }
        return s;
    }
}


// class Solution {
//     public int findPeakElement(int[] nums) {
//         int s = 0;
//         int e = nums.length - 1;
        
//         while (s < e) {  // Fix: Use s < e
//             int m = s + (e - s) / 2;
            
//             if (nums[m] > nums[m + 1]) {  // Fix: Use nums instead of arr
//                 e = m;  // Fix: Use e = m instead of e = m - 1
//             } else {
//                 s = m + 1;
//             }
//         }
//         return s;  // Both s and e point to the peak
//     }
// }
