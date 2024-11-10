class Solution {
    public int minimumSubarrayLength(int[] numbers, int threshold) {
        int arrayLength = numbers.length;
        int[] bitCounts = new int[32];
        int currentOrValue = 0;
        int leftIndex = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int rightIndex = 0; rightIndex < arrayLength; rightIndex++) {
            currentOrValue |= numbers[rightIndex];
            
            for (int bit = 0; bit < 32; bit++) {
                if ((numbers[rightIndex] & (1 << bit)) != 0) {
                    bitCounts[bit]++;
                }
            }
            
            while (leftIndex <= rightIndex && currentOrValue >= threshold) {
                minLength = Math.min(minLength, rightIndex - leftIndex + 1);
                
                int updatedOrValue = 0;
                for (int bit = 0; bit < 32; bit++) {
                    if ((numbers[leftIndex] & (1 << bit)) != 0) {
                        bitCounts[bit]--;
                    }
                    if (bitCounts[bit] > 0) {
                        updatedOrValue |= (1 << bit);
                    }
                }
                currentOrValue = updatedOrValue;
                leftIndex++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
