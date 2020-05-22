public class _416分割等和子集 {

    //方法一 dp
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum%2==1)
            return false;
        boolean[] dp=new boolean[20001];
        dp[0]=true;
        for (int num : nums) {
            for (int i=dp.length-1;i>=0;i--){//从后往前填表，无后效性
                if (i-num>=0 && dp[i-num])
                    dp[i]=true;
            }
        }
        return dp[sum/2];
    }

    //方法2 dfs 把某个数放到集合一或者集合二中，如果刚好有个满足条件 则返回
    /*if(res1==0 ||res2==0)
        return true;
    if(res1<0 ||res2<0)
        return false;
    return dfs(res1-val,res2,lvl-1)||dfs(res1,res2-val,lvl-1)*/
}
