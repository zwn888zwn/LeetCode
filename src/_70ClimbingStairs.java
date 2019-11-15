public class _70ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp=new int[n+2];
        dp[0]=0;dp[1]=1;
        //从2开始算
        for(int i=2;i<=n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n+1];
    }
}
