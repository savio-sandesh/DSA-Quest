class Solution {
    public static List<Integer> primes;
    public static boolean preComputed = false;
    public int[] closestPrimes(int left, int right) {
        if(!preComputed){
            primes = preComputeIsPrime();
            preComputed = true;
        }

        int start = upperBound(primes,left);
        int end = lowerBound(primes,right);

        if(end - start < 1 || start == -1 || end == -1)return new int[]{-1,-1};

        int[] res = new int[2];
        int diff = right;
        for(int i = start; i <= end - 1; i++){
            if(primes.get(i + 1) - primes.get(i) < diff){
                res[0] = primes.get(i);
                res[1] = primes.get(i + 1);
                diff = res[1] - res[0];
            }
        } 
        return res;
    }

    public int upperBound(List<Integer> arr,int target){
        int s = 0, e = arr.size() - 1;
        int ans = -1;
        while(s <= e){
            int mid = s + ( e - s ) / 2;
            if(arr.get(mid) >= target){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }

    public int lowerBound(List<Integer> arr,int target){
        int s = 0, e = arr.size() - 1;
        int ans = -1;
        while(s <= e){
            int mid = s + ( e - s ) / 2;
            if(arr.get(mid) <= target){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }

    public List<Integer> preComputeIsPrime(){
        boolean[] isPrime = new boolean[(int)(1e6) + 1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;isPrime[1] = false;
        for(int i = 2; (i * i) <= (int)(1e6); i++){
            if(isPrime[i]){
                for(int j = i * i; j <= (int)(1e6); j += i){
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= (int)(1e6); i++){
            if(isPrime[i])primes.add(i);
        }

        return primes;
    }
}