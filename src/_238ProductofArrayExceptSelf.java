public class _238ProductofArrayExceptSelf {
    //左右乘法
    public int[] productExceptSelf(int[] nums) {
        if (nums.length==1)
            return nums;
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        int product=1;
        left[0]=1;right[nums.length-1]=1;
        for (int i=0;i<nums.length;i++){
            left[i]=product;
            product=product*nums[i];
        }
        product=1;
        for (int i=nums.length-1;i>=0;i--){
            right[i]=product;
            product=product*nums[i];
        }
        for (int i=0;i<nums.length;i++){
            nums[i]=left[i]*right[i];
        }
        return nums;
    }
}
