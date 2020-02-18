import java.util.Arrays;

public class _416PartitionEqualSubsetSum {
    //todo 没写出来
    //转化为物品只能拿1次的01背包问题
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) != 0) return false; //判断奇偶
        boolean[] dp = new boolean[(sum >> 1) + 1];//dp[i]能不能达到
        dp[0] = true;
        for (int num : nums) {//对每个数字尝试，尽可能的达到，不会出现一个数字多次统计（因为是分别对每个数字进行操作的）
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] |= dp[i - num];
                if (dp[dp.length - 1]) return true;
            }
        }
        return dp[dp.length - 1];
    }
}
