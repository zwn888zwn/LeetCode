import java.util.ArrayList;
import java.util.List;

public class _448FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;){
            if (i+1==nums[i] || nums[i]==nums[nums[i]-1]){
                i++;
                continue;
            }else {
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        for (int i=0;i<nums.length;i++){
            if (i+1!=nums[i])
                res.add(i+1);
        }
        return res;
    }
}
