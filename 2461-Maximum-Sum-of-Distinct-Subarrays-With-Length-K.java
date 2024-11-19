
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> elementCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            elementCount.put(nums[i], elementCount.getOrDefault(nums[i], 0) + 1);

            if (i >= k) {
                currentSum -= nums[i - k];
                elementCount.put(nums[i - k], elementCount.get(nums[i - k]) - 1);
                if (elementCount.get(nums[i - k]) == 0) {
                    elementCount.remove(nums[i - k]);
                }
            }

            if (elementCount.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
