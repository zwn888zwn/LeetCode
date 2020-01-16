public class _309BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length==0)
            return 0;
        int[] dp=new int[prices.length];//第i天卖 积累的利润
        for (int i=1;i<prices.length;i++){
            dp[i]=dp[i-1];
            for (int j=i-1;j>=0;j--){//买卖
                int sell=prices[i]-prices[j]+(j-2>0?dp[j-2]:0);
                dp[i]=Math.max(dp[i],sell);
            }
        }
        return dp[prices.length-1];
    }

    public static void main(String[] args) {
        _309BestTimetoBuyandSellStockwithCooldown obj=new _309BestTimetoBuyandSellStockwithCooldown();
        obj.maxProfit(new int[]{1,2,3,0,2});
    }
}
