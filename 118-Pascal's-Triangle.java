class Solution {
    public List<List<Integer>> generate(int numRows) {
        // 2d arraylist
        List<List<Integer>> pascal =new ArrayList<>();

        for(int i=0;i<numRows;i++){
            // new list to store an individual row of triangle
            List<Integer> row=new ArrayList<>();

            // add 1 at the beginning 
            row.add(1);
            
            // calculate the values b/w 1
            for(int j=1;j<i;j++){
                int value = pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j);
                row.add(value);
            }

            // add 1 at the end of each row expect 1st row
            if(i>0){
                row.add(1);
            }
            pascal.add(row);
        }
        return pascal;
    }
}