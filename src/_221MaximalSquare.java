public class _221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int res=0;
        if (matrix.length==0)
            return 0;
        int[][] dp=new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'){
                    dp[i][j]=Math.min(j-1>=0?dp[i][j-1]:0,Math.min(i-1>=0?dp[i-1][j]:0,i-1>=0&&j-1>=0?dp[i-1][j-1]:0))+1;
                    res=Math.max(res,dp[i][j]);
                }
            }
        }
        return res*res;
    }
}
