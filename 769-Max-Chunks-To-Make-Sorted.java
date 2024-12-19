class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int maxTillNow = -1;
        int chunksCount = 0;

        for (int i = 0; i < n; i++) {
            maxTillNow = Math.max(maxTillNow, arr[i]);

            if (maxTillNow == i) {
                chunksCount++;
            }
        }

        return chunksCount;
    }
}
