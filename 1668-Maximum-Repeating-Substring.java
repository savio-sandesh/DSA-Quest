class Solution {
    public int maxRepeating(String seq, String word) {
        int count=0;
        
        String con=word;
        while(word.length()<=seq.length())
        {
             if(seq.contains(word))
             {
                count++;
             }
             else
             {
                 break;
             }
             word+=con;
        }
        return count;
        
    }
}