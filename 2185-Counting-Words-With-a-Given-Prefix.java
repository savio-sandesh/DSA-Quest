class Solution {
    public int prefixCount(String[] words, String pref) {
        int c=0; // count variable
        int n=pref.length();
        for (String word : words) 
        { 
            if (word.startsWith(pref)) 
            { 
                c++; 
            } 
        }
        return c;
    }
}