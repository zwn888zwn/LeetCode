public class _543二叉树的直径 {
    int maxD=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null)
            return 0;
        maxD=Math.max(getMaxDepth(root.left)+getMaxDepth(root.right),maxD);
        return maxD;
    }
    public int getMaxDepth(TreeNode root){
        if (root==null)
            return 0;
        int leftD=getMaxDepth(root.left);
        int rightD=getMaxDepth(root.right);
        maxD=Math.max(leftD+rightD,maxD);
        return Math.max(leftD,rightD)+1;
    }

}
