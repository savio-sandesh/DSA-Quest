class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int x = nums.length;
        for(int i =0;i<k;i++){
            int index=0;
            for(int j =0;j<x;j++){
                if(nums[j]<nums[index]){
                    index=j;
                }
            }
            nums[index]*=multiplier;
        }  
        return nums;
    }
}