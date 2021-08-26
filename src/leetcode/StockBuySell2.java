package leetcode;

public class StockBuySell2 {
    // can buy and sell multiple times but only hold one shar at a time
    public int maxProfit(int[] prices) {
        int top;
        int bottom;
        int profit = 0;
        int i = 0;
        while( i < prices.length - 1) {
            // iterate till we get local minima
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            bottom = prices[i];
            // iterate till we get local maxima
            while( i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            top = prices[i];
            profit += top - bottom;
        }
        return profit;
    }
}
