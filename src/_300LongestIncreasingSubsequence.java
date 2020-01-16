public class _300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int res=1;
        if (nums.length==0)
            return 0;
        int[] dp=new int[nums.length];
        dp[0]=1;
        for (int i=1;i<nums.length;i++){
            int maxLen=1;
            for(int j=0;j<i;j++){
                if (nums[j]<nums[i])
                    maxLen=Math.max(maxLen,dp[j]+1);
            }
            dp[i]=maxLen;
            res=Math.max(res,maxLen);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={10,9,2,5,3,7,101,18};
        _300LongestIncreasingSubsequence obj=new _300LongestIncreasingSubsequence();
        obj.lengthOfLIS(arr);
    }
}
