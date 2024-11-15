import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            int leftBound = findLowerBound(nums, i + 1, nums.length - 1, lower - nums[i]);
            int rightBound = findUpperBound(nums, i + 1, nums.length - 1, upper - nums[i]);

            if (rightBound >= leftBound) {
                count += rightBound - leftBound + 1;
            }
        }

        return count;
    }

    private int findLowerBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int findUpperBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
