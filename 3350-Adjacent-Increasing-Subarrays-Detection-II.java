class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k,int[] lis) {
        for(int i=0;i+2*k<=nums.size();i++){
            if(lis[i+k-1]>=k && lis[i+k+k-1]>=k){
                return true;
            }
        }
        return false;
    }
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int[] lis=new int[nums.size()];
        lis[0]=1;
        for(int i=1;i<nums.size();i++){
            lis[i]=1;
            if(nums.get(i)>nums.get(i-1)){
                lis[i]=lis[i-1]+1;
            }
        }
        int low=1;
        int high=nums.size()/2;
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(hasIncreasingSubarrays(nums,mid,lis)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}