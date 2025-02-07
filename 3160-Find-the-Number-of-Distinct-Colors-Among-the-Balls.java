class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballMap = new HashMap<>();
        HashMap<Integer, Integer> colorMap = new HashMap<>();

        int n = queries.length;
        int result[] = new int[n];

        int ball = 0, color = 0;
        for(int i = 0; i < n; i++)
        {
            ball = queries[i][0];
            color = queries[i][1];

            if(ballMap.containsKey(ball))
            {
                int previousColor = ballMap.get(ball);
                if(colorMap.get(previousColor) == 1)
                    colorMap.remove(previousColor);
                else
                    colorMap.put(previousColor, colorMap.get(previousColor) - 1);
            }

            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

            result[i] = colorMap.size();
        } 

        return result;
    }
}