class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1){
            return 0;
        }
        
        int min_price = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if(min_price > price){
                min_price = price;
            }

            maxProfit = Math.max(price - min_price, maxProfit);
        }
        return maxProfit;
        
    }
}
