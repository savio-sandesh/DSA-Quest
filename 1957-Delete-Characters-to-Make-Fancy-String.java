class Solution {
    public String makeFancyString(String s) {
        StringBuilder newstr=new StringBuilder();
        int count =1;
        newstr.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else{
                count=1;
            }
            if(count<3){
                newstr.append(s.charAt(i));
            }
        }
        return newstr.toString();
    }
}