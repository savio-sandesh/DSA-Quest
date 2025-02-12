class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum=Integer.MIN_VALUE;
        for(int i=0;i<accounts.length;i++){
            int add=0;
            for(int j=0;j<accounts[i].length;j++){
                add+=accounts[i][j];
            }
            if(add>sum){
                sum=add;
            }
        }
        return sum;
    }
}