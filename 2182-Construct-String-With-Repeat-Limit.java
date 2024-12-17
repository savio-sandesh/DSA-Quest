class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // freq.array to store character counts
        int[] count = new int[26]; 
        
        // count the freq. of each character
        for (char ch:s.toCharArray()) {
            count[ch-'a']++;
        }
        
        StringBuilder result = new StringBuilder();
        int i=25;

        while(i>=0) {
            if (count[i] == 0) {
                i--;
                continue;
            }

            // convert index to character
            char ch = (char) ('a' + i); 
            // append up to 'repeatLimit' times
            int freq = Math.min(count[i],repeatLimit); 
            
            for (int k=0; k<freq; k++) {
                result.append(ch);
            }
            count[i] -= freq;

            if (count[i]>0) {
                // find the next largest character
                int j = i-1;
                while (j >=0 && count[j]==0) {
                    j--;
                }

                if (j<0) {
                    break; 
                }
                
                // append the next largest character once
                result.append((char) ('a' + j)); 
                count[j]--;
            }
        }
        return result.toString();
    }
}
