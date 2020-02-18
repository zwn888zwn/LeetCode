import java.util.HashMap;
import java.util.Map;

public class _437PathSumIII {

    Map<Integer,Integer> map=new HashMap<>();
    int count=0;

    public int pathSum(TreeNode root, int target) {
        if (root==null)
            return 0;
        dfs(root,0,target);
        return count;
    }
    //todo 没做出来，看答案代码后明白,自己再写代码
    //因为是求途中的和为目标值就行
    //如果从root到当前和为X，只需要看之前路径X-target能到几个即可
    public void dfs(TreeNode root, int sum,int target){
        sum+=root.val;
        if (sum==target)
            count++;
        //更新map sum值,顺序不能反，0的情况
        count+=map.getOrDefault(sum-target,0);
        map.put(sum,map.getOrDefault(sum,0)+1);
        if (root.left!=null){
            dfs(root.left,sum,target);
        }
        if (root.right!=null){
            dfs(root.right,sum,target);
        }
        map.put(sum,map.get(sum)-1);//回溯
    }
}
