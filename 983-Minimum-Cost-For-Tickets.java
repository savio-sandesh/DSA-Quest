class Solution {
    public int mincostTickets(int[] travelDays, int[] ticketCosts) {
        int numDays = travelDays.length;
        int[] minCost = new int[numDays + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;
        
        for (int i = 1; i <= numDays; i++) {
            // Cost for 1-day pass
            minCost[i] = minCost[i - 1] + ticketCosts[0]; 
            
            int k = i - 1;
            while (k >= 0 && travelDays[i - 1] - travelDays[k] < 7) k--;
            // Cost for 7-day pass
            minCost[i] = Math.min(minCost[i], minCost[k + 1] + ticketCosts[1]); 
            
            k = i - 1;
            while (k >= 0 && travelDays[i - 1] - travelDays[k] < 30) k--;
            // Cost for 30-day pass
            minCost[i] = Math.min(minCost[i], minCost[k + 1] + ticketCosts[2]); 
        }
        
        return minCost[numDays];
    }
}
