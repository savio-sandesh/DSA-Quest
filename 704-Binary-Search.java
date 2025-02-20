class Solution {
    public int search(int[] nums, int target) {
        int s=0;
        int e = nums.length-1;
        return recur(nums,s,target,e);
    }
        
    public int recur(int[] nums,int s,int target,int e){
        if(s>e){
            return -1;
            }
            int mid=s+(e-s)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target>nums[mid]){
                return recur(nums,mid+1,target,e);
            }else{
                return recur(nums,s,target,mid-1);
            }
    }
}

// iterative approach

// while(low<=high){
        //     int mid = low + (high-low)/2;
        //     if(nums[mid]==target){
        //         return mid;
        //     }
        //     else if(nums[mid]<target){
        //         low =mid+1;
        //      }
        //     else{
        //         high=mid-1;
        //     }
        // }
        // return -1;