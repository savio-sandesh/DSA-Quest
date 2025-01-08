class Solution {
    private boolean isPrefixAndSuffix(String check, String s) {
        int n = check.length();

        String s1 = s.substring(0, n);
        String s2 = s.substring(s.length() - n);

        return s1.equals(check) && s2.equals(check);
    }

    public int countPrefixSuffixPairs(String[] words) {
        
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() <= words[j].length() && isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }
}