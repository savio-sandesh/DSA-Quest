class Solution {
    public int[] resultsArray(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            boolean con = true;

            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] + 1 != nums[j + 1]) {
                    con = false;
                    break;
                }
            }

            if (con) {
                int max = nums[i];
                for (int j = i + 1; j < i + k; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                    }
                }
                res[i] = max;
            } else {
                res[i] = -1;
            }
        }

        return res;
    }
}
