class Solution {
    public long countSubarrays(int[] nums, long k) {
        if (k <= 1) return 0; 

        long ans = 0;
        long sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum * (right - left + 1) >= k && left <= right) {
                sum -= nums[left];
                left++;
            }

            ans += (right - left + 1);
        }

        return ans;
    }
}
