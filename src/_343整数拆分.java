public class _343整数拆分 {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];//dp[i]=maxValue dp[i]=max{dp[i-k]*k}
        //如何保证至少2个
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for (int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],dp[i-j]*j);
                dp[i]=Math.max(dp[i],(i-j)*j);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        _343整数拆分 obj=new _343整数拆分();
        obj.integerBreak(10);
    }
}
