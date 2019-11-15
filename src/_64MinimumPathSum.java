public class _64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=Integer.MAX_VALUE;
        }
        for (int j=0;j<m+1;j++)
            dp[0][j]=Integer.MAX_VALUE;
        dp[1][0]=0;
        //M是列 N是行
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[n][m];
    }

}
