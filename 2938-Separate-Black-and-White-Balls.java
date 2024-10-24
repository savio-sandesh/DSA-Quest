class Solution {
    public long minimumSteps(String s) {
        long c=0;
        long st=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                c++;
            }
            else{
                st+=c;
            }
        }
        if(c==s.length()){
            return 0;
        }
        else{
            return st;
        }
    }
}