import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _16最接近的三数之和 {
    //推荐方法 双指针
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=nums[0] + nums[1] +nums[2];
        for (int i=0;i<nums.length-2;i++){
            int begin=i+1,end=nums.length-1;
            while (begin<end){
                int sum=nums[i]+nums[begin]+nums[end];
                if (Math.abs(target-sum)<Math.abs(target-ans))
                    ans=sum;

                if (sum == target){
                    return target;
                }else if (sum> target){
                    end--;
                }else{
                    begin++;
                }


            }
        }
        return ans;
    }



    //1 排序
    //2 构造个map key=a+b v=min index
    //3 遍历map 把index+1后的数再加上
    //4 最后线程搜索target 左右 n^2
    public int threeSumClosest1(int[] nums, int target) {//不行，比暴力好不到哪去
        Arrays.sort(nums);//1
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length-1;i++){//2
            for (int j=i+1;j<nums.length;j++){
                map.put(nums[i]+nums[j],Math.min(j,map.getOrDefault(nums[i]+nums[j],2000)));
            }
        }
        Set<Integer> keySet = map.keySet();
        Set<Integer> resSet= new HashSet<>();
        for (Integer key : keySet) {
            int index=map.get(key)+1;
            for(;index<nums.length;index++){
                resSet.add(key+nums[index]);
            }
        }

        for(int i=0;i<10001;i++){
            if (resSet.contains(target+i)){
               return target+i;
            }
            if (resSet.contains(target-i)){
                return target-i;
            }

        }
        return target;
    }
}
