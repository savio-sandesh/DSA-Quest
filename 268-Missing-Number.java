class Solution {
    public int missingNumber(int[] nums) {
        // Arrays.sort(nums);
        int n = nums.length;
        // int low=0;
        // int high = n;
        // int count = 0;

        // for(int i =0;i<n;i++){
        //     if()

        int sum =0;
        int sumofn= (n*(n+1))/2;
        for(int i=0;i<n;i++)
        {
            int num = nums[i]; 
            sum+= num;

        } 
        return sumofn-sum;
    }
}