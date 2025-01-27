class Solution {
    public int maxProfit(int[] prices) {
        
        int buy_time = Integer.MAX_VALUE;

        int max_sum = 0;

        for(int i = 0; i<prices.length; i++)
        {
            if(buy_time < prices[i])
            {
                int rem = prices[i] - buy_time;

                max_sum = Math.max(rem , max_sum);
            }
            else
            {
                buy_time = prices[i];
            }
        }

        return max_sum;

        
    }
}