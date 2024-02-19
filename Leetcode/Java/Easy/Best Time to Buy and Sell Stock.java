class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        if(prices.length == 1) return 0;

        for(int i: prices){
            if(min > i){
                min = i;
                continue;
            }
            if(i > min){
                maxProfit = maxProfit < i-min? i-min:maxProfit;
            }
        }
        return maxProfit;
    }
}
