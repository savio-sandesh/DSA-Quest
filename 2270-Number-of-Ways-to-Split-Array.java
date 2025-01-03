class Solution {
    public int waysToSplitArray(int[] nums) {
        int length = nums.length;

        // Calculate the total sum of the array
        long totalsum = 0;
        for (int number : nums) {
            totalsum += number;
        }

        long leftpartsum = 0;
        long rightpartsum = 0;
        int validsplits = 0;

        // Iterate through the array to calculate leftpartsum and rightpartsum
        for (int i = 0; i < length - 1; i++) {
            leftpartsum += nums[i];
            rightpartsum = totalsum - leftpartsum;

            if (leftpartsum >= rightpartsum) {
                validsplits++;
            }
        }

        return validsplits;
    }
}