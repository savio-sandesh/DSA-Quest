class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int strLength = s.length();
        int[] netShifts = new int[strLength]; // Array to store the net shifts for each character

        // Step 1: Populate the net shifts array
        for (int[] operation : shifts) {
            int startIndex = operation[0];
            int endIndex = operation[1];
            int shiftDirection = operation[2];

            if (shiftDirection == 1) { // Forward shift
                netShifts[startIndex] += 1;
                if (endIndex + 1 < strLength) {
                    netShifts[endIndex + 1] -= 1;
                }
            } else { // Backward shift
                netShifts[startIndex] -= 1;
                if (endIndex + 1 < strLength) {
                    netShifts[endIndex + 1] += 1;
                }
            }
        }

        // Step 2: Compute the cumulative sum to determine the net shift for each character
        for (int i = 1; i < strLength; i++) {
            netShifts[i] += netShifts[i - 1]; // Add the value from the previous index
        }

        // Step 3: Apply the net shifts to the input string
        StringBuilder transformedString = new StringBuilder(s);
        for (int i = 0; i < strLength; i++) {
            int shiftAmount = netShifts[i] % 26; // Ensure the shift amount is within the range [0, 25]
            if (shiftAmount < 0) {
                shiftAmount += 26; // Handle negative shifts (backward)
            }

            // Apply the calculated shift to the character
            char newChar = (char) (((transformedString.charAt(i) - 'a' + shiftAmount) % 26) + 'a');
            transformedString.setCharAt(i, newChar);
        }

        return transformedString.toString();
    }
}
