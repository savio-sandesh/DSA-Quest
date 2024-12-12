class Solution {
    public long pickGifts(int[] g, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int gift:g) {
            pq.add(gift);
        }
        
        for (int i=0; i<k; i++) {
            int max = pq.poll();
            int rem = (int) Math.floor(Math.sqrt(max));
            pq.add(rem);
        }
        
        long total=0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }
        return total;
    }
}
