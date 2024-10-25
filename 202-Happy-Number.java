class Solution {
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {  // Loop continues until n is 1 or a cycle is detected
            int rem, newnum = 0;
            while (n > 0) {         // Loop to calculate sum of squares of digits
                rem = n % 10;
                newnum += rem * rem;
                n /= 10;
            }
            n = newnum;
        }
        return n == 1;               // Return true if n is 1 (happy number), else false
    }
}
