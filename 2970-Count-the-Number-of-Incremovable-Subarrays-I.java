class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        if (nums.length == 1)
            return 1;

        int n = nums.length;
        int res = 0;

        // left side
        int li = 0, lj = 1;
        while (lj < n) {
            if (nums[lj] <= nums[lj-1])
                break;
            lj++;
        }
        lj--;
        if (lj == n-1)
            return (n * (n + 1)) / 2;

        res += lj - li + 1;

        // right side
        int ri = n - 2, rj = n - 1;
        while (ri > 0) {
            if (nums[ri] >= nums[ri+1])
                break;
            ri--;
        }
        ri++;
        res += rj - ri + 1;

        // middle
        for (int i = li; i <= lj; i++) {
            int j = ri;
            while (j < n) {
                if (nums[j] > nums[i]) {
                    res += rj - j + 1;
                    break;
                }
                j++;
            }
        }

        return res+1;
    }
}