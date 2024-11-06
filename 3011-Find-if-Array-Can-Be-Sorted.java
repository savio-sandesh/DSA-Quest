class Solution {
    public boolean canSortArray(int[] nums) {
        boolean swap;
        for(int p=0;p<nums.length;++p){
            swap=false;
            for(int i=0;i<nums.length-1;++i){
                if(nums[i]>nums[i+1]){
                    if(Integer.bitCount(nums[i])==Integer.bitCount(nums[i+1])){
                    nums[i]=nums[i]^nums[i+1];
                    nums[i+1]=nums[i]^nums[i+1];
                    nums[i]=nums[i]^nums[i+1];
                    swap=true;
                }
                }
            }
            if(!swap){
                break;
            }
        }
        for(int i=1;i<nums.length;++i){
            if(nums[i]<nums[i-1])return false;
        }
        return true;
    }
}