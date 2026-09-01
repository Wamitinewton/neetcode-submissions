class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int best = 0;

        for (int i = 1; i<n; i++) {
            int profit = prices[i] - minPrice;
            best = Math.max(best, profit);

            minPrice = Math.min(minPrice, prices[i]);
        }

        return best;
        
    }
}
