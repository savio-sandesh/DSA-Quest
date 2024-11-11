class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] nums = new int[501];
        for(int k:arr){
            nums[k]++;
        }

        for(int i=500;i>0;i--){
            if(i==nums[i]){
                return i;
            }
        }
        return -1;
    }
}