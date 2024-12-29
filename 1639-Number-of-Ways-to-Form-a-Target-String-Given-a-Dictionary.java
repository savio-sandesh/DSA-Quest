import java.util.*;

public class Solution {
    private static final int MOD = 1000000007;
    private int[][] mem;
    private int targetSize;
    private int wordSize;
    private int n;
    private int[][] charFreq;

    private int countWays(String[] words, int idx, String target, int tpos) {
        if (tpos == targetSize) // Match
            return idx <= wordSize ? 1 : 0;
        if (idx >= wordSize || (wordSize - idx < targetSize - tpos)) // No Match or Insufficient Size
            return 0;
        if (mem[idx][tpos] != -1) // Repeating sub-problem
            return mem[idx][tpos];

        char curr = target.charAt(tpos);

        long waysByNotMatching = countWays(words, idx + 1, target, tpos);
        long waysByMatching = countWays(words, idx + 1, target, tpos + 1) % MOD;
        long totalWays = (waysByNotMatching + (long)charFreq[idx][curr - 'a'] * waysByMatching) % MOD;

        return mem[idx][tpos] = (int)totalWays;
    }

    public int numWays(String[] words, String target) {
        targetSize = target.length();
        wordSize = words[0].length();
        n = words.length;
        charFreq = new int[wordSize][26];
        mem = new int[wordSize + 1][targetSize + 1];

        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        // Calculate char freq for each position
        for (String word : words) {
            for (int j = 0; j < wordSize; j++) {
                char curr = word.charAt(j);
                charFreq[j][curr - 'a']++;
            }
        }

        return countWays(words, 0, target, 0);
    }
}
