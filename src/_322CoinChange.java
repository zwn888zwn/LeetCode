import java.util.Arrays;

public class _322CoinChange {
    /**
     * 总结：递推式很快就写出了，但是在边界处理上，调试了很久。
     * Q1，找不开的情况，不自觉的去加0
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount==0)
            return 0;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);//原来fill-1 失误
        dp[0]=0;
        for (int i=1;i<=amount;i++){
            for (int j=0;j<coins.length;j++){ //尝试找零
                if (i-coins[j]>=0){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return (dp[amount]>amount)?-1:dp[amount];
    }

    public static void main(String[] args) {
        _322CoinChange obj=new _322CoinChange();
        obj.coinChange(new int[]{2},1);
    }
}
