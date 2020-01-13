public class _283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroMark=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                swap(nums,i-zeroMark,i);
            }else {
                zeroMark++;
            }
        }
    }

    private void swap(int[] nums, int zeroMark, int i) {
        if (zeroMark-i==0) return;
        int temp=nums[zeroMark];
        nums[zeroMark]=nums[i];
        nums[i]=temp;
    }
}
