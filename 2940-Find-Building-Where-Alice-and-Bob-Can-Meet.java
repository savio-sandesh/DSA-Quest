class Solution {
    // Segment Tree for RMQ: Range Max Query
    private int[] segTree; // Segment Tree

    private void buildSegmentTree(int[] heights, int start, int end, int st_idx) {
        if (start == end) {
            segTree[st_idx] = start;
            return;
        }

        int mid = start + (end - start) / 2;
        buildSegmentTree(heights, start, mid, 2 * st_idx);
        buildSegmentTree(heights, mid + 1, end, 2 * st_idx + 1);

        segTree[st_idx] = heights[segTree[2 * st_idx]] >= heights[segTree[2 * st_idx + 1]] ?
                segTree[2 * st_idx] : segTree[2 * st_idx + 1];
    }

    private int rangeMaxQuery(int[] heights, int qs, int qe, int start, int end, int st_idx) {
        if (start >= qs && end <= qe) // Total Overlap
            return segTree[st_idx];
        if (start > qe || end < qs) // No Overlap
            return Integer.MIN_VALUE;

        // Partial Overlap
        int mid = start + (end - start) / 2;
        int left_max = rangeMaxQuery(heights, qs, qe, start, mid, 2 * st_idx);
        int right_max = rangeMaxQuery(heights, qs, qe, mid + 1, end, 2 * st_idx + 1);

        if (left_max == Integer.MIN_VALUE) return right_max;
        if (right_max == Integer.MIN_VALUE) return left_max;
        return heights[left_max] >= heights[right_max] ?
                left_max : right_max;
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        segTree = new int[4 * n + 1];
        int st_idx = 1; // Segment Tree Index: Root at index 1 for segment tree implementations

        buildSegmentTree(heights, 0, n - 1, st_idx);

        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            int alice = Math.min(query[0], query[1]);
            int bob = Math.max(query[0], query[1]);

            if (alice == bob || heights[bob] > heights[alice]) {
                res.add(bob);
                continue;
            }

            // Binary Search + RMQ (Range Max Query)
            int low = bob;
            int high = n - 1;
            int ans = Integer.MAX_VALUE;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int rmq = rangeMaxQuery(heights, low, mid, 0, n - 1, st_idx);

                if (heights[rmq] > heights[alice]) {
                    high = mid - 1;
                    ans = Math.min(ans, rmq);
                } else {
                    low = mid + 1;
                }
            }
            if (ans == Integer.MAX_VALUE) res.add(-1);
            else res.add(ans);
        }

        // Convert List<Integer> to int[]
        return res.stream().mapToInt(i -> i).toArray();
    }
}
