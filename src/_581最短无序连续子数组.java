import java.util.Arrays;

public class _581最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr= Arrays.copyOf(nums,nums.length);
        Arrays.sort(arr);
        int left=nums.length-1;
        int right=0;
        for(int i=0;i<arr.length;i++){
            if (arr[i]!=nums[i]){
                left=Math.min(left,i);
                right=Math.max(right,i);
            }
        }
        return right>left?(right-left+1):0;
    }
}
