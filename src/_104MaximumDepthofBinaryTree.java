public class _104MaximumDepthofBinaryTree {
    int maxLen=0;
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        dfs(root,1);
        return maxLen;
    }
    public void dfs(TreeNode treeNode,int deep){
        maxLen=Math.max(maxLen,deep);
        if (treeNode.left!=null)
            dfs(treeNode.left ,deep+1);
        if (treeNode.right!=null)
            dfs(treeNode.right,deep+1);
    }
}
