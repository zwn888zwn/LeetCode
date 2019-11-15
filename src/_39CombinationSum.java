import java.util.ArrayList;
import java.util.List;

public class _39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recursion(candidates,target,0,new ArrayList<>());
        return result;
    }

    List<List<Integer>> result=new ArrayList<>();
    public void recursion(int[] candidates, int target,int nowSum,List<Integer> arr){
        for(int i=0;i<candidates.length;i++){
            if (arr.size()>0){
                int maxNum =arr.get(arr.size()-1);
                if (maxNum>candidates[i])
                    continue;
            }
            if(nowSum+candidates[i]==target){
                List<Integer> temp=new ArrayList<>(arr);
                temp.add(candidates[i]);
                result.add(temp);
            }else if (nowSum+candidates[i]<target){
                List<Integer> temp=new ArrayList<>(arr);
                temp.add(candidates[i]);
                recursion(candidates, target, nowSum+candidates[i], temp);
            }
        }
    }

    public static void main(String[] args) {
        _39CombinationSum obj=new _39CombinationSum();
        obj.combinationSum(new int[]{2,3,6,7},7);
    }
}
