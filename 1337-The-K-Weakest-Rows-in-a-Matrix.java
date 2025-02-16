class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int count_soldiers = 0;
        int[] arr = new int[mat.length];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j]==1){
                    count_soldiers++;
                }
            }
            arr[i] = count_soldiers;
            count_soldiers = 0;
        }
        
        int[] new_arr = new int[arr.length];
        System.arraycopy(arr, 0, new_arr, 0, new_arr.length);
        Arrays.sort(new_arr);
        int[] ans = new int[k];
        
        int min;
        for(int i=0; i<k; i++){
            min = i;
            for(int j=0; j<arr.length; j++){
                if(arr[j]==new_arr[min] && arr[j]!=-1){
                    min = j;
                    arr[j] = -1;
                    break;
                }
            }
            ans[i] = min;
        }
        return ans;
    }
}