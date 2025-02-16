class Solution {
    int sum(int arr[]){
        int s=0;
        for(int val : arr) s+=val;
        return s;
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = sum(A);
        int sumB = sum(B);
        for(int i=0;i<A.length;i++)
            for(int j=0;j<B.length;j++)
                if(sumA-A[i]+B[j] == sumB-B[j]+A[i]) 
                    return new int[]{A[i],B[j]};
               
        return new int[2];
    }
}