public class _121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length==0)
            return 0;
        int maxPro=0,nowMin=prices[0];
        for(int i=0;i<prices.length;i++){
            if (prices[i]>nowMin){
                maxPro=Math.max(maxPro,prices[i]-nowMin);
            }else {
                nowMin=prices[i];
            }
        }
        return maxPro;
    }
}
