class Solution {
    public int maxScore(String s) {
        int maxPoints = 0;
        int leftZeros = 0;
        int rightOnes = (int) s.chars().filter(ch -> ch == '1').count();

        for (int i = 0; i < s.length() - 1; i++) {
            leftZeros += s.charAt(i) == '0' ? 1 : 0;
            rightOnes -= s.charAt(i) == '1' ? 1 : 0;
            maxPoints = Math.max(maxPoints, leftZeros + rightOnes);
        }

        return maxPoints;
    }
}
