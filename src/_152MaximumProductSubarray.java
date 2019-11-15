public class _152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int max_ending = nums[0];
        int min_ending = nums[0];
        int max = nums[0];

        for(int i=1; i<nums.length; i++){
            int max_ending_here = Math.max(nums[i], Math.max(nums[i]*max_ending, nums[i]*min_ending));
            min_ending = Math.min(nums[i], Math.min(nums[i]*max_ending, nums[i]*min_ending));

            max_ending = max_ending_here;

            if(max_ending>max) max = max_ending;
        }

        return max;
    }
}
