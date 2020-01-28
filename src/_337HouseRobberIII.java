public class _337HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res=dp(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dp(TreeNode root){// 0选择 1不选
        if (root==null){
            return new int[]{0,0};
        }
        int[] left=dp(root.left);
        int[] right=dp(root.right);
        int[] res=new int[2];
        res[0]=root.val+left[1]+right[1];
        res[1]=Math.max(left[0]+right[0],res[1]);
        res[1]=Math.max(left[0]+right[1],res[1]);
        res[1]=Math.max(left[1]+right[0],res[1]);
        res[1]=Math.max(left[1]+right[1],res[1]);
        return res;
    }
}
