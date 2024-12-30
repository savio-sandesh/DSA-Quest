public class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int result = 0;
        final int MOD = 1000000007;

        dp[0] = 1;

        for (int i = 1; i <= high; ++i) {
            // Check if we can add zero length string
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % MOD;
            }
            // Check if we can add one length string
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            }
            // Add to result if current length is within the low-high range
            if (i >= low) {
                result = (result + dp[i]) % MOD;
            }
        }

        return result;
    }
}
