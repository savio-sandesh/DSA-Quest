class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int e = (int) Math.pow(2, maximumBit); 
        int[] prexor = new int[nums.length]; 
        prexor[0] = nums[0]; 
        for (int i = 1; i < nums.length; i++) 
        { 
            prexor[i] = prexor[i - 1] ^ nums[i]; 
        } 
        int[] res = new int[nums.length]; 
        for (int i = prexor.length - 1, j = 0; i >= 0; i--, j++) 
        { 
            res[j] = (e - 1) ^ prexor[i];
        } 
        return res;
    }
}