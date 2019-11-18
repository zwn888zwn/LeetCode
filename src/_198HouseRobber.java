public class _198HouseRobber {
    public int rob(int[] nums) {
        if (nums.length==0)
            return 0;
        int[] dp=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int max=nums[i];
            if (i-1>=0)
            max=Math.max(max,dp[i-1]);
            if (i-2>=0)
            max=Math.max(max,dp[i-2]+nums[i]);
            if (i-3>=0)
            max=Math.max(max,dp[i-3]+nums[i]);
            dp[i]=max;
        }
        return dp[nums.length-1];
    }
}
