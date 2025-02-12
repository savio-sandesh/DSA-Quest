class Solution {
    public int findNumbers(int[] nums) {
        int n=0;
        for(int i=0;i<nums.length;i++){
            String str=Integer.toString(nums[i]);
            int size=str.length();
            if(size%2==0){
                n++;
            }
        }
        return n;
    }
}