class Solution {
    public boolean isMonotonic(int[] nums) {
    //    if (Arrays.sort(nums)==1) return true;
    //    if (Arrays.sort(nums, Collections.reverseOrder())==1) return true;
    //    else false;

    int x=nums.length;
    if(x<=2) return true;

    // ascending order 
    boolean ascending = true; 
    for (int i = 1; i < nums.length; i++)
    { 
        if (nums[i] < nums[i - 1]) 
        { 
            ascending = false; 
            break;
        } 
    } 
    // descending order 
    boolean descending = true; 
    for (int i = 1; i < nums.length; i++) 
    { 
        if (nums[i] > nums[i - 1]) { 
        descending = false;
        break;
        } 
    } 
    // either ascending or descending 
    return ascending || descending;
}
}