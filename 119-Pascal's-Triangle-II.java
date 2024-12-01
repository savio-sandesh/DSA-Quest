class Solution {
    public List<Integer> getRow(int rowIndex) {
         List<Integer> row=new ArrayList<>();
    
        for(int i=0;i<=rowIndex;i++){

            // add 1 at the beginning 
            row.add(1);
            
            // calculate the values b/w 1
            for (int j = i - 1; j > 0; j--) { 
                row.set(j, row.get(j) + row.get(j - 1));
                }    
        }
        return row;

    }
}