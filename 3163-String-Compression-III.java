class Solution {
    public String compressedString(String word) {
        StringBuilder comp= new StringBuilder();
        int count =0;
        for(int i =0;i<word.length();++i){
            count=0;
            for(int j=i;j<word.length();++j){
                if(count==9){
                break;
                }
                if(word.charAt(i)==word.charAt(j)){count++;}
                else break;
            }
            i=i+count-1;
            
            comp.append(count);
            comp.append(word.charAt(i));
            
        }
        return comp.toString();
    }
}