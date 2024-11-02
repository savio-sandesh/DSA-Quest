class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        
        // Check all consecutive word pairs
        for (int i = 1; i < words.length; i++) {
            char lastCharPreviousWord = words[i - 1].charAt(words[i - 1].length() - 1);
            char firstCharCurrentWord = words[i].charAt(0);
            if (lastCharPreviousWord != firstCharCurrentWord) {
                return false;
            }
        }
        
        // Additionally, ensure the sentence is circular by checking the last word and the first word
        char lastCharLastWord = words[words.length - 1].charAt(words[words.length - 1].length() - 1);
        char firstCharFirstWord = words[0].charAt(0);
        return lastCharLastWord == firstCharFirstWord;
    }

}
