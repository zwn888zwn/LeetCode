import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _494TargetSum {
    Map<Integer,Integer> map=new HashMap();
    public int findTargetSumWays(int[] nums, int S) {
        map.put(nums[0],map.getOrDefault(nums[0],0)+1);
        map.put(-nums[0],map.getOrDefault(-nums[0],0)+1);
        for (int i=1;i<nums.length;i++) {
            Set<Integer> keys=map.keySet();
            Map<Integer,Integer> tempMap=new HashMap();
            for (Integer key : keys) {

                    tempMap.put(key-nums[i],map.get(key)+tempMap.getOrDefault(key-nums[i],0));
                    tempMap.put(key+nums[i],map.get(key)+tempMap.getOrDefault(key+nums[i],0));
                

            }
            map=tempMap;
        }
        return map.getOrDefault(S,0);
    }

    public static void main(String[] args) {
        _494TargetSum obj=new _494TargetSum();
        System.out.println(obj.findTargetSumWays(new int[]{1,2,1},0));
    }
}
