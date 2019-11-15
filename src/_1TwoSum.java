import java.util.Arrays;

public class _1TwoSum {


    public static int[] twoSum(int[] nums, int target) {
        int[] temp=Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return findIndex(temp,nums[i],nums[j]);
                }else if(nums[i]+nums[j]>target){
                    break;
                }
            }
        }
        return new int[]{0,0};
    }

    public static int[] findIndex(int[] arr,int num1,int num2){
        int index1=0,index2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==num1){
                index1=i;
                break;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==num2&&i!=index1){
                index2=i;
                break;
            }
        }
        return new int[]{index1,index2};
    }

    public static void main(String[] args) {
        int[] arr={3,2,4};
        int[] result=twoSum(arr,6);
        System.out.println(result[0]+","+result[1]);
    }
}
