public class _62UniquePaths {
    int[][] dp=new int[101][101];
    public int uniquePaths(int m, int n) {
        //M是列 N是行
        dp[0][0]=1;dp[0][1]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n][m];
    }
}
