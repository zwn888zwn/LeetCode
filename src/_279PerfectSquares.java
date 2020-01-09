public class _279PerfectSquares {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        return recur(dp,n);
    }
    public int recur(int[] dp,int n){
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        if (dp[n]!=0)
            return dp[n];
        int res=n;
        for(int i=(int)Math.sqrt(n);i>=1;i--){
            res=Math.min(res,recur(dp,n-i*i)+1);
        }
        dp[n]=res;
        return res;
    }

    public static void main(String[] args) {
        _279PerfectSquares obj=new _279PerfectSquares();
        System.out.println(obj.numSquares(4));
    }
}
