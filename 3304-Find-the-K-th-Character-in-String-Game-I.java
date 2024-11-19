public class Solution {
    public char kthCharacter(int k) {
    //     // Start with the initial string "a"
    //     String word = "a";
    //     // Call the recursive function to generate the required string
    //     return generateWord(word, k).charAt(k - 1);
    // }

    // // Recursive function to generate the word until it reaches at least k characters
    // private String generateWord(String word, int k) {
    //     // Base case: If the current word length is at least k, return the word
    //     if (word.length() >= k) {
    //         return word;
    //     }
        
    //     // Generate the new string by changing each character to its next character
    //     StringBuilder newWord = new StringBuilder(word);
    //     for (int i = 0; i < word.length(); i++) {
    //         char nextChar = (char) ((word.charAt(i) - 'a' + 1) % 26 + 'a');
    //         newWord.append(nextChar);
    //     }
        
    //     // Append the new string to the current word and continue the recursion
    //     return generateWord(newWord.toString(), k);



    // mathematical approach

        // Calculate the full cycles required
        int length = 1;
        int cycle = 0;
        while (length < k) {
            length *= 2;
            cycle++;
        }

        // Determine the character at the k-th position
        return findKthCharacter(cycle, k);
    }

    private char findKthCharacter(int cycle, int k) {
        if (cycle == 0) {
            return 'a';
        }

        int lengthOfPreviousCycle = (1 << (cycle - 1)); // Equivalent to 2^(cycle-1)
        if (k <= lengthOfPreviousCycle) {
            return findKthCharacter(cycle - 1, k);
        } else {
            int newK = k - lengthOfPreviousCycle;
            char prevChar = findKthCharacter(cycle - 1, newK);
            return (char) ((prevChar - 'a' + 1) % 26 + 'a');
        }
    }
}
