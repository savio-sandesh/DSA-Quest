class Solution {
    public int arrangeCoins(int n) {
        long c=0;
        for(int i=1;i<=n;i++){
            c+=i;
            if(c==n){
                return i;
            }
            if(c>n){
                return i-1;
            }
        }
        return -1;
    }
}