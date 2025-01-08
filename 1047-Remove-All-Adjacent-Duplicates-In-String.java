// class Solution {
//     public int largestSumAfterKNegations(int[] nums, int k) {
//         int x=nums.length;
//         int sum=0;
//         Arrays.sort(nums);
//         for(int j =0;j<x && k>0;j++){
//             if(nums[j]<0)
//             {
//             nums[j]=-nums[j];
//             k--;
//             }
//         }
//         if (k % 2 != 0) 
//         { 
//             Arrays.sort(nums);
//             nums[0] = -nums[0]; 
//         }
//         for(int i=0;i<x;i++){
//             sum+=nums[i];
//         }
//         return sum;
//     }
// }
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        for(int i=0;i<k;++i){
            int a=min(nums);
            nums[a]=-nums[a];
        }
        int a=0;
        for(int i=0;i<nums.length;++i){
            a+=nums[i];
        }
        return a;
    }
    public static int min(int[] a){
        int m=101;
        int j=0;
        for(int i=0;i<a.length;++i){
            if(a[i]<m){
                m=a[i];
                j=i;
            }
        }
        return j;
    }
    
}