class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            // int count=0;
            // for(int j =i+1;j<n;j++){
            //     if(temperatures[j]>temperatures[i]){
            //         ans[i]=count;
            //         break;
            //     }
            // } 
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int id = st.pop();
                ans[id]=i-id;
            }
            st.push(i);
        }
        return ans;
    }
}