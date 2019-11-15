public class _114FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        TreeNode p=root,q;
        while(p!=null){
            if(p.left!=null){
                q=p.left;
                while(q.right!=null)
                    q=q.right;
                q.right=p.right;
                p.right=p.left;
                p.left=null;
            }
            p=p.right;
        }

    }
}
