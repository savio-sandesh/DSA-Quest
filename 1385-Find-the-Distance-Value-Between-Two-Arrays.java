class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    int distanceValue = 0;

        for (int num1 : arr1) {
            boolean isValid = true;

            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    isValid = false;
                    break; 
                }
            }
            if (isValid) {
                distanceValue++;
            }
        }

        return distanceValue;
    }
}