public class _96UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        if (n==1)
            return 1;
        return dfs(n,dp);
    }
    public int dfs(int n,int[] dp){
        if (n==0||n==1)
            return 1;
        if(dp[n]!=0)
            return dp[n];
        int sum=0;
        for(int i=0;i<=n-1;i++){
            int temp=dfs(i,dp)*dfs(n-1-i,dp);//组合是乘不是加
            sum+= temp==0?1:temp;
        }
        dp[n]=sum;
        return sum;
    }

    public static void main(String[] args) {
        _96UniqueBinarySearchTrees obj=new _96UniqueBinarySearchTrees();
        System.out.println(obj.numTrees(6));
    }
}
