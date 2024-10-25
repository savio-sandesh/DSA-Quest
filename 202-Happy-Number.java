class Solution {
    public boolean isHappy(int n) {
        // while (n != 1 && n != 4) {  // Loop continues until n is 1 or a cycle is detected
        //     int rem, newnum = 0;
        //     while (n > 0) {         // Loop to calculate sum of squares of digits
        //         rem = n % 10;
        //         newnum += rem * rem;
        //         n /= 10;
        //     }
        //     n = newnum;
        // }
        // return n == 1;               // Return true if n is 1 (happy number), else false

     
        // Using two pointers (low and high) to detect a cycle
        int low = n;
        int high = getNext(n);
        
        // Loop until high pointer reaches 1 (happy) or we detect a cycle
        while (high != 1 && low != high) {
            low = getNext(low);             // Move low pointer one step
            high = getNext(getNext(high));  // Move high pointer two steps
        }
        
        // If high pointer is 1, it's a happy number
        return high == 1;
    }

    // Helper method to compute the next number in the sequence
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;  // Extract the last digit
            totalSum += digit * digit;  // Square the digit and add to total
            n /= 10;  // Remove the last digit
        }
        return totalSum;


    }
}
