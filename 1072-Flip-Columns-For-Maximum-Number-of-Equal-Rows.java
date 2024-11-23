class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        int maxCount = 0;

        for (int[] row : matrix) {
            int firstValue = row[0];
            StringBuilder str = new StringBuilder();

            for (int i = 0; i < m; i++) {
                char ch = firstValue == row[i] ? 'S' : 'D';
                str.append(ch);
                firstValue = row[i];
            }

            String key = str.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            maxCount = Math.max(maxCount, map.get(key));
        }

        return maxCount;
    }
}
