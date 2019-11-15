public class _41FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]>0)
                count++; //统计大于0的个数
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && nums[i]<=count && nums[nums[i]-1]!= nums[i]){//把i放在i-1的位置上
                int temp1=nums[nums[i]-1];
                int temp2=nums[i];
                nums[nums[i]-1]=temp2;
                nums[i]=temp1;
                i--;//交换后nums[i]的数又变了，继续交换
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){ //如果位置上没有数 就输出
                return i+1;
            }
        }
        return count+1; //一一对应就输出最后的数

    }
}
