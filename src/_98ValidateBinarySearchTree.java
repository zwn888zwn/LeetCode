public class _98ValidateBinarySearchTree {
    long compareValue=Long.MIN_VALUE;
    boolean isValid=true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isValid;
    }
    public void inorder(TreeNode root){
        if (root!=null){
            inorder(root.left);
            if(root.val<=compareValue)
                isValid=false;
            else {
                compareValue=root.val;
            }
            inorder(root.right);
        }

    }
}
