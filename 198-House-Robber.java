class Solution {
    public int rob(int[] nums) {
        int x=nums.length;
        if(nums==null || x==0) return 0;
        if(x==1) return nums[0];
        if(x==2) return Math.max(nums[0],nums[1]);

        int dp[]=new int[x];
        dp[0]=nums[0];
        dp[1]=Integer.max(nums[1],nums[0]);
        for(int i= 2;i<x;i++){
            dp[i]=Integer.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[x-1];



        // int sum1=0;
        // int sum2=0;
        // for(int i =0;i<nums.length;i++){
        //     if(i%2!=0){
        //         sum1+=nums[i];
        //     }
        //     else{
        //         sum2+=nums[i];
        //     }
        // }
        // return Math.max(sum1,sum2);
    }
}