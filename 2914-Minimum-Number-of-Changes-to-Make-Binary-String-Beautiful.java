class Solution {
    public int minChanges(String s) {
        // if(s.contains("1")) return 0;
        // if(s.contains("0")) return 0;
        int c=0;
        for(int i=0;i<s.length()-1;i+=2){
            if(s.charAt(i)!=s.charAt(i+1)){
                c++;
            }
        }
        return c;
        
    }
}