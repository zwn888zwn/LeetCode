import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

//letcode31
public class _46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        long count=factorial(nums.length);
        while (count>0){
            List<Integer> arr=new ArrayList<>();
            for (int num : nums) {
                arr.add(num);
            }
            ans.add(arr);
            nextPermutation(nums);
            count--;
        }
        return ans;
    }

    private long factorial(int length) {
        long result=1;
        while (length>1){
            result*=length;
            length--;
        }
        return result;
    }


    public void nextPermutation(int[] nums) {
        //1 find a< a+1
        int a,b;
        for(a=nums.length-2;a>=0;a--){
            if (nums[a]<nums[a+1]){
                break;
            }
        }
        if(a<0)
            a=0;
        // 2 find smallest b>a
        for(b=nums.length-1;b>a;b--){
            if(nums[b]>nums[a]){
                break;
            }
        }

        //3 change a b
        int temp;
        if (b<=a){
            b=nums.length-1;
        }
        else {
            temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
            a++;
        }

        //4 reverse a+1 - n
        b=nums.length-1;
        while (a<=b){
            temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
            a++;
            b--;
        }

    }
}
