public class _538把二叉搜索树转换为累加树 {
    //1 直接遍历，有序保存，在map，再次遍历读取map更新值 nlogn
    //2 利用二叉搜索树左小右大   先右后左 o(n)
    int largeThanMe=0;
    int tempVal=0;
    public TreeNode convertBST(TreeNode root) {
        if (root==null){
            return null;
        }
        if (root.right!=null){
            convertBST(root.right);
        }
        tempVal=root.val;
        root.val+=largeThanMe;
        largeThanMe+=tempVal;
        if (root.left!=null){
            convertBST(root.left);
        }
        return root;
    }
}
