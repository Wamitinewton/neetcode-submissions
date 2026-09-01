class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int best = 0;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int price = prices[j]-prices[i];
                best = Math.max(best, price);
            }
        }

        if (best < 0) {
            return 0;
        } else {
            return best;
        }
        
    }
}
