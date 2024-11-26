class Solution {
    public int findChampion(int n, int[][] edges) {
        int [] indegree=new int[n];
 
        // indegree => number of edges directed towards
        //             a vertex/node
        // calculating indegree for each node

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            //u-->v
            indegree[v]++;
        }

        int champ=-1;
        int count=0;

        // champion check 
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                champ=i;
                count++;
                if(count>1){
                    return -1;
                }
            }
        }
        return champ;

    }
}