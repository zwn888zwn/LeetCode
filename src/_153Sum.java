import java.util.*;

public class _153Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result =new LinkedHashSet<>();
        if (nums.length<3)
            return new ArrayList<>();
        int[] temp= Arrays.copyOf(nums,nums.length);
        Arrays.sort(temp);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j && nums[i]<=nums[j]){
                    int sum=nums[i]+nums[j];
                    if (nums[j]<=-sum) {
                        int index=Arrays.binarySearch(temp,-sum);
                        if(index>-1){
                            // index可以在排序时确定 效率为N^2
                            //目前效率N^3
                            for(int k=0;k<nums.length;k++){
                                if(nums[k]==-sum){
                                    index=k;
                                    break;
                                }
                            }
                            if (index !=i && index!=j){
                                ArrayList<Integer> list=new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(-sum);
                                result.add(list);
                            }
                        }


                    }
                }
            }
        }
        List<List<Integer>> changedToList=new ArrayList<>();
        for (List<Integer> list : result) {
            changedToList.add(list);
        }
        return changedToList;
    }

    public static void main(String[] args) {
        int[] arr={0,-1,1};
        new _153Sum().threeSum(arr);
    }
}
