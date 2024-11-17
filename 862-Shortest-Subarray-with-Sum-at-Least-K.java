class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        
        Deque<Integer> dq = new LinkedList<>();
        int minLen = n + 1;
        
        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && preSum[i] - preSum[dq.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - dq.pollFirst());
            }
            
            while (!dq.isEmpty() && preSum[i] <= preSum[dq.peekLast()]) {
                dq.pollLast();
            }
            
            dq.offerLast(i);
        }
        
        return minLen == n + 1 ? -1 : minLen;
    }
}
