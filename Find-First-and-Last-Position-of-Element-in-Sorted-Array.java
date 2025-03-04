class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        res[0]=findfirst(nums,target);
        res[1]=findlast(nums,target);
        return res;
    }
    public int findfirst(int[] nums, int target){
        int idx=-1;
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(target>nums[m]){
                s=m+1;
            }
            else if(target<nums[m]){
                e=m-1;
            }
            else if(nums[m]==target){
                idx=m;
                e = m - 1;
            }
        }
        return idx;
    }

    public int findlast(int[] nums, int target){
        int idx=-1;
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(target>nums[m]){
                s=m+1;
            }
            else if(target<nums[m]){
                e=m-1;
            }
            else if(nums[m]==target){
                idx=m;
                s = m + 1;
            }
        }
        return idx;
    }
}